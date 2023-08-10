package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.HospitalInfoDto;
import com.smiley.smileybackend.dto.response.dtolist.HospitalGeocodingDtoList;
import com.smiley.smileybackend.dto.response.dtolist.HospitalInfoDtoList;
import com.smiley.smileybackend.dto.response.dtolist.SimpleHospitalInfoDtoList;
import com.smiley.smileybackend.dto.user.UserGeocodingDto;
import com.smiley.smileybackend.service.HospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "Hospital Controller : 병원 정보")
public class HospitalController {
        private final HospitalService hospitalService;
        public HospitalController(HospitalService hospitalService){
            this.hospitalService=hospitalService;
        }

        @GetMapping("/hospitals/{hPid}")
        @ApiOperation(value="단일 병원 정보" , notes = "단일 병원 정보를 반환한다")
        @ApiResponse(message = "병원 정보를 찾을 수 없습니다",code=400)
        public ResponseEntity<HospitalInfoDto> hospital(@PathVariable String hPid){
            HospitalInfoDto hospitalInfoDto = hospitalService.findHospital(hPid);
            return ResponseEntity.ok(hospitalInfoDto);
        }

        @GetMapping("hospitals/simpleInfos")
        @ApiOperation(value="모든 병원의 간단한 정보" , notes = "모든 병원의 간단한 정보를 반환한다.")
        public ResponseEntity<SimpleHospitalInfoDtoList> simplehostitalinfos(){
            SimpleHospitalInfoDtoList hospitals = hospitalService.getSimpleHospitalInfo();
            return ResponseEntity.ok(hospitals);
        }

        @GetMapping("hospitals/allInfos")
        @ApiOperation(value="모든 병원의 모든 정보" , notes = "모든 병원의 모든 정보를 반환한다.")
        public ResponseEntity<HospitalInfoDtoList> hostitalinfos(){
            HospitalInfoDtoList hospitals = hospitalService.getHospitalInfos();
            return ResponseEntity.ok(hospitals);
        }

        @PostMapping("hospitals/nearBy")
        public ResponseEntity<HospitalGeocodingDtoList>  nearhospitalinfos(@Valid @RequestBody UserGeocodingDto userGeocodingDto){
            HospitalGeocodingDtoList hospitals = hospitalService.getNearHospitalInfos(userGeocodingDto);
            return ResponseEntity.ok(hospitals);
        }
}
