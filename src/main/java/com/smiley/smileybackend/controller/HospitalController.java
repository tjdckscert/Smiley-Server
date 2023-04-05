package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.HospitalInfoDto;
import com.smiley.smileybackend.dto.response.SimpleHospitalInfo;
import com.smiley.smileybackend.service.HospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(tags = "Hospital Controller : 병원 정보")
public class HospitalController {
        private HospitalService hospitalService;
        public HospitalController(HospitalService hospitalService){
            this.hospitalService=hospitalService;
        }

        @GetMapping("/hospitals/{id}")
        @ApiOperation(value="단일 병원 정보" , notes = "단일 병원 정보를 반환한다")
        public ResponseEntity<HospitalInfoDto> hospital(@PathVariable Integer id){
            HospitalInfoDto hospitalInfoDto = hospitalService.findHospital(id);
            return ResponseEntity.ok(hospitalInfoDto);
        }

        @GetMapping("hospitals/simpleinfo")
        @ApiOperation(value="모든 병원 정보" , notes = "모든 병원 정보를 반환한다.")
        public ResponseEntity<List<SimpleHospitalInfo>> simplehostitalinfos(){
            List<SimpleHospitalInfo> simpleHospitalInfo = hospitalService.getSimpleHospitalInfo();
            return ResponseEntity.ok(simpleHospitalInfo);
        }
}
