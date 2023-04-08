package com.example.deuproject.projectentity.openapi;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.repository.HospitalRepository;
import com.smiley.smileybackend.service.HospitalService;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ApiController {

    private final HospitalService hospitalService;

    @Autowired
    private HospitalRepository hospitalRepository;
    public ApiController(HospitalService hospitalService){
        this.hospitalService=hospitalService;
    }

    @GetMapping("open-api")
    public JSONObject fetch() throws UnsupportedEncodingException {
        String url= "http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncListInfoInqire?serviceKey=J4Eet0ufB15SNzWemvPGDerm64fEPPBrmMe1NACJVDNjMFGWynCXesFOHbAMw%2BrYQ1cgYfMXn5QsQH9XVtt7GA%3D%3D";
        URI uri = null;
        try {
            uri = new URI(url.toString());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String res = restTemplate.getForObject(uri, String.class);
        JSONObject xmlJson = XML.toJSONObject(res);
        JSONArray parsingArrays = xmlJson.getJSONObject("response").getJSONObject("body").getJSONObject("items").getJSONArray("item");
        List<Hospital> h= new ArrayList<>();
        for (int i=0;i<parsingArrays.length();i++){
            JSONObject jsonObject =  parsingArrays.getJSONObject(i);
            log.info("i = "+i+" "+jsonObject.toString());
            h.add(hospitalService.saveJson(jsonObject,i));
        }
        log.info(h.toString());
        hospitalRepository.saveAll(h);

        return  xmlJson;
    }
}
