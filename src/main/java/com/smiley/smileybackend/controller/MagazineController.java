package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.MagazineInfoDto;
import com.smiley.smileybackend.service.MagazineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Magazine Controller : 매거진 정보")
public class MagazineController {
    private MagazineService magazineService;
    public MagazineController(MagazineService magazineService){
        this.magazineService=magazineService;
    }

    @GetMapping("/magazines")
    @ApiOperation(value="모든 매거진" , notes = "모든 매거진 정보를 반환한다.")
    public ResponseEntity<List<MagazineInfoDto>> magazines(){
        List<MagazineInfoDto> magazineInfos = magazineService.getAll();
        return ResponseEntity.ok(magazineInfos);
    }

    @GetMapping("/magazines/{number}")
    @ApiOperation(value="선택수량 매거진" , notes = "선택한 수량만큼의 매거진 정보를 반환한다.")
    public ResponseEntity<List<MagazineInfoDto>> numberOfMagazines(@PathVariable Integer number){
        List<MagazineInfoDto> magazineInfos = magazineService.getListOfNumber(number);
        return ResponseEntity.ok(magazineInfos);
    }

}
