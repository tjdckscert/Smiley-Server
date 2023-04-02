package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.MedicineInfoDto;
import com.smiley.smileybackend.dto.user.MedicineIdDto;
import com.smiley.smileybackend.service.MedicineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@ToString
@RestController
@Api(tags = "Medicine Controller :  의약품 정보")
@Slf4j

public class MedicineController {
    private MedicineService medicineService;
    public MedicineController(MedicineService medicineService){
        this.medicineService = medicineService;
    }

    @PostMapping("/medicine")
    @ApiOperation(value="의약품 정보 조회" , notes = "Id 값을 통해 단일 의약품 정보를 가져온다")
    public ResponseEntity<MedicineInfoDto> medicine(@Valid @RequestBody MedicineIdDto medicineIdDto) {
        MedicineInfoDto medicineInfoDto = medicineService.findMedicine(medicineIdDto);
        log.info(medicineInfoDto.toString());
        return ResponseEntity.ok(medicineInfoDto);
    }
}
