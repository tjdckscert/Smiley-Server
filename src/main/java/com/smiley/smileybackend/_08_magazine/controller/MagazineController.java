package com.smiley.smileybackend._08_magazine.controller;

import com.smiley.smileybackend._08_magazine.dto.MagazineDetailDto;
import com.smiley.smileybackend._08_magazine.dto.MagazineInfoDtoList;
import com.smiley.smileybackend._00_common.exception.ErrorCode;
import com.smiley.smileybackend._08_magazine.service.MagazineService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "Magazine Controller : 매거진 정보")
public class MagazineController {
    private final MagazineService magazineService;
    public MagazineController(MagazineService magazineService){
        this.magazineService=magazineService;
    }

    @GetMapping("/magazines")
    @ApiOperation(value="모든 매거진" , notes = "모든 매거진 정보를 반환한다.")
    public ResponseEntity<MagazineInfoDtoList> magazines(@RequestParam(value = "page",defaultValue = "0") Integer page, @RequestParam(value = "size",defaultValue = "5") Integer size){
        MagazineInfoDtoList magazines = magazineService.getAll(page,size);
        return ResponseEntity.ok(magazines);

    }

    @GetMapping("/magazines/")
    @ApiOperation(value="선택수량 매거진(필요?)" , notes = "선택한 수량만큼의 매거진 정보를 반환한다.")
    public ResponseEntity<MagazineInfoDtoList> numberOfMagazines(@RequestParam("number") Integer number){
        MagazineInfoDtoList magazines = magazineService.getListOfNumber(number);
        return ResponseEntity.ok(magazines);
    }

    @GetMapping("/magazines/{number}")
    @ApiOperation(value="선택한 메저긴 정보 불러오기" , notes = "선택한 메거진의 정보를 불러와서 반환한다. 사진은 서버에 저장된 사진을 반환.")
    @ApiResponses(value = {
            @ApiResponse(response = ErrorCode.class, message = "사진을 불러올 수 없습니다.", code = 500),
            @ApiResponse(response = ErrorCode.class, message = "등록되지 않은 메거진 번호입니다.", code = 423)
    })
    public ResponseEntity<MagazineDetailDto> magazineinfo(@PathVariable Integer number) {
        MagazineDetailDto magazineDetailDto =magazineService.getMagazineDetail(number);
        return ResponseEntity.ok(magazineDetailDto);
    }

}
