package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.MedicineInfoDto;
import com.smiley.smileybackend.service.MedicineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ToString
@RestController
@Api(tags = "Medicine Controller :  의약품 정보")
@Slf4j
public class MedicineController {
    private MedicineService medicineService;
    public MedicineController(MedicineService medicineService){
        this.medicineService = medicineService;
    }

    @GetMapping("/medicines/{id}")
    @ApiOperation(value="의약품 정보 조회" , notes = "Id 값을 통해 단일 의약품 정보를 가져온다")
    public ResponseEntity<MedicineInfoDto> medicine(@PathVariable Integer id) {
        MedicineInfoDto medicineInfoDto = medicineService.findMedicine(id);
        log.info(medicineInfoDto.toString());
        return ResponseEntity.ok(medicineInfoDto);
    }

    @GetMapping("/medicines")
    @ApiOperation(value="모든 의약품 정보 조회" , notes = "모든 의약품 정보를 가져온다")
    public ResponseEntity<List<MedicineInfoDto>> medicines() {
        List<MedicineInfoDto> medicineInfoDto = medicineService.getAll();
        return ResponseEntity.ok(medicineInfoDto);
    }
}
