package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.HospitalInfoDto;
import com.smiley.smileybackend.service.HospitalService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Hospital Controller : 병원 정보")
public class HospitalController {
        private HospitalService hospitalService;
        public HospitalController(HospitalService hospitalService){
            this.hospitalService=hospitalService;
        }

        @GetMapping("/hospitals/{id}")
        public ResponseEntity<HospitalInfoDto>hospital(@PathVariable Integer id){
            HospitalInfoDto hospitalInfoDto = hospitalService.findHospital(id);
            return ResponseEntity.ok(hospitalInfoDto);
        }
}
