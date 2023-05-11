package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.MagazineDetailDto;
import com.smiley.smileybackend.dto.response.dtolist.MagazineInfoDtoList;
import com.smiley.smileybackend.service.MagazineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
    public ResponseEntity<MagazineInfoDtoList> magazines(){
        MagazineInfoDtoList magazines = magazineService.getAll();
        return ResponseEntity.ok(magazines);
    }

    @GetMapping("/magazines/") //쿼리 파라미터로 변경
    @ApiImplicitParam(name="number",value="가져올 매거진의 수량",example = "1")
    @ApiOperation(value="선택수량 매거진" , notes = "선택한 수량만큼의 매거진 정보를 반환한다.")
    public ResponseEntity<MagazineInfoDtoList> numberOfMagazines(@RequestParam("number") Integer number){
        MagazineInfoDtoList magazines = magazineService.getListOfNumber(number);
        return ResponseEntity.ok(magazines);
    }

    @GetMapping("/magazines/{number}")
    @ApiOperation(value="선택한 메저긴 정보 불러오기" , notes = "선택한 메거진의 정보를 불러와서 반환한다. 사진은 서버에 저장된 사진을 반환.")
    public ResponseEntity<MagazineDetailDto> magazineinfo(@PathVariable Integer number) {
        MagazineDetailDto magazineDetailDto =magazineService.getMagazineDetail(number);
        return ResponseEntity.ok(magazineDetailDto);
    }

}
