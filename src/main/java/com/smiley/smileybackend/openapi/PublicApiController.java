package com.smiley.smileybackend.openapi;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.Medicine;
import com.smiley.smileybackend.service.HospitalService;
import com.smiley.smileybackend.service.MedicineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.XML;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@ToString
@Slf4j
@Api(tags = "PublicApiController : 공공 API")
public class PublicApiController {

    private final HospitalService hospitalService;

    private final MedicineService medicineService;

    public PublicApiController(HospitalService hospitalService, MedicineService medicineService){
        this.hospitalService=hospitalService;
        this.medicineService=medicineService;
    }

    @GetMapping("open-api/hospital")
    @ApiOperation(value="공공 데이터 포털 국립중앙의료원_국립중앙의료원_전국 병·의원 찾기 서비스 사용" , notes = "병원 정보들을 가져와서 DB에 저장한다.")
    public void hospitalFetch() throws URISyntaxException {
        String url;
        String res;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        URI uri = null;
        JSONArray jsonArray;
        for (Integer i=1;;i++) {
            url = "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire?serviceKey=J4Eet0ufB15SNzWemvPGDerm64fEPPBrmMe1NACJVDNjMFGWynCXesFOHbAMw%2BrYQ1cgYfMXn5QsQH9XVtt7GA%3D%3D&numOfRows=500&pageNo=" + i;
            uri = new URI(url);

            res = restTemplate.getForObject(uri, String.class);
            try{
                jsonArray = XML.toJSONObject(res).
                        getJSONObject("response").
                        getJSONObject("body").
                        getJSONObject("items").
                        getJSONArray("item");
            }
            catch ( Exception e) {
                break;
            }
            List<Hospital> hospitals = new ArrayList<>();
            for (int j = 0; j < jsonArray.length(); j++) {
                if (jsonArray.getJSONObject(j).optString("dutyDiv").equals("N") || jsonArray.getJSONObject(j).optString("dutyDiv").equals("M")) {
                    log.info((jsonArray.getJSONObject(j).toString()));
                    hospitals.add(Hospital.jsonToEntity(jsonArray.getJSONObject(j)));
                }
            }
            hospitalService.saveAll(hospitals);
        }
    }

    @GetMapping("open-api/medicine")
    @ApiOperation(value="공공 데이터 포털 식품의약품안전처_의약품 낱알식별 정보 사용" , notes = "의약품 정보들을 가져와서 DB에 저장한다.")
    public void medicineFetch() throws URISyntaxException {
        String url;
        String res;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        URI uri;
        JSONArray jsonArray;
        for (Integer i =1;;i++) {
            url = "http://apis.data.go.kr/1471000/MdcinGrnIdntfcInfoService01/getMdcinGrnIdntfcInfoList01?serviceKey=J4Eet0ufB15SNzWemvPGDerm64fEPPBrmMe1NACJVDNjMFGWynCXesFOHbAMw%2BrYQ1cgYfMXn5QsQH9XVtt7GA%3D%3D&numOfRows=300&pageNo="+i;
            uri = new URI(url);
            res = restTemplate.getForObject(uri, String.class);
            try{
                jsonArray = XML.toJSONObject(res).
                        getJSONObject("response").
                        getJSONObject("body").
                        getJSONObject("items").
                        getJSONArray("item");
            }
            catch ( Exception e) {
                break;
            }
            List<Medicine> medicines = new ArrayList<>();
            for (int j = 0; j < jsonArray.length(); j++) {
                medicines.add(Medicine.jsonToEntity(jsonArray.getJSONObject(j)));
            }
            medicineService.saveAll(medicines);
        }
    }
}
