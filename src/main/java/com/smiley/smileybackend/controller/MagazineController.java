package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.MagazineInfoDto;
import com.smiley.smileybackend.service.MagazineService;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ToString
@NoArgsConstructor
public class MagazineController {
    private MagazineService magazineService;
    public MagazineController(MagazineService magazineService){
        this.magazineService=magazineService;
    }

    @GetMapping("/magazines")
    public ResponseEntity<List<MagazineInfoDto>> magazines(){
        List<MagazineInfoDto> magazineInfos = magazineService.getAll();
        return ResponseEntity.ok(magazineInfos);

    }

}
