package com.smiley.smileybackend.openapi;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.Medicine;
import com.smiley.smileybackend.service.HospitalService;
import com.smiley.smileybackend.service.MedicineService;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.XML;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@ToString
@Slf4j
public class PublicApiController {

    private final HospitalService hospitalService;

    private final MedicineService medicineService;

    public PublicApiController(HospitalService hospitalService, MedicineService medicineService){
        this.hospitalService=hospitalService;
        this.medicineService=medicineService;
    }

    @GetMapping("open-api/hospital")
    public void fetch() throws UnsupportedEncodingException {
        String url= "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire?serviceKey=J4Eet0ufB15SNzWemvPGDerm64fEPPBrmMe1NACJVDNjMFGWynCXesFOHbAMw%2BrYQ1cgYfMXn5QsQH9XVtt7GA%3D%3D&numOfRows=10";
        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String res = restTemplate.getForObject(uri, String.class);
        JSONArray parsingArrays = XML.toJSONObject(res)
                .getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items")
                .getJSONArray("item");
        List<Hospital> hospitals= new ArrayList<>();
        for (int i=0;i<parsingArrays.length();i++){
            hospitals.add(Hospital.jsonToEntity(parsingArrays.getJSONObject(i)));
        }
        hospitalService.saveAll(hospitals);
    }

    @GetMapping("open-api/medicine")
    public void medicineFetch() throws UnsupportedEncodingException {
        String url = "http://apis.data.go.kr/1471000/MdcinGrnIdntfcInfoService01/getMdcinGrnIdntfcInfoList01?serviceKey=J4Eet0ufB15SNzWemvPGDerm64fEPPBrmMe1NACJVDNjMFGWynCXesFOHbAMw%2BrYQ1cgYfMXn5QsQH9XVtt7GA%3D%3D&pageNo=";
        RestTemplate restTemplate = new RestTemplate();
        String res;
        JSONArray jsonArray;
        for (Integer i =1; i<=84;i++) {
            url = "http://apis.data.go.kr/1471000/MdcinGrnIdntfcInfoService01/getMdcinGrnIdntfcInfoList01?serviceKey=J4Eet0ufB15SNzWemvPGDerm64fEPPBrmMe1NACJVDNjMFGWynCXesFOHbAMw%2BrYQ1cgYfMXn5QsQH9XVtt7GA%3D%3D&numOfRows=300&pageNo="+i.toString();
            URI uri = null;
            try {
                uri = new URI(url);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
            res = restTemplate.getForObject(uri, String.class);
            jsonArray = XML.toJSONObject(res).getJSONObject("response").getJSONObject("body").getJSONObject("items").getJSONArray("item");
            List<Medicine> medicines = new ArrayList<>();
            for (int j = 0; j < jsonArray.length(); j++) {
                medicines.add(Medicine.jsonToEntity(jsonArray.getJSONObject(j)));
            }
            medicineService.saveAll(medicines);
        }
    }
}
