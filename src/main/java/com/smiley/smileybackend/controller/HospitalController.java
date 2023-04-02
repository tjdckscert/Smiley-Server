package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.HospitalInfoDto;
import com.smiley.smileybackend.dto.user.HospitalIdDto;
import com.smiley.smileybackend.service.HospitalService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = "Hospital Controller : 병원 정보")
public class HospitalController {
        private HospitalService hospitalService;
        public HospitalController(HospitalService hospitalService){
            this.hospitalService=hospitalService;
        }

        @PostMapping("/hospital")
        public ResponseEntity<HospitalInfoDto>hospital(@Valid @RequestBody HospitalIdDto hospitalIdDto){
            HospitalInfoDto hospitalInfoDto = hospitalService.findHospital(hospitalIdDto);
            return ResponseEntity.ok(hospitalInfoDto);
        }
}
