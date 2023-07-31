package com.smiley.smileybackend.controller;


import com.smiley.smileybackend.dto.response.ProtrusionMouthImageDto;
import com.smiley.smileybackend.dto.response.ToothBrushImageDto;
import com.smiley.smileybackend.service.ProtrusionMouthCheckService;
import com.smiley.smileybackend.service.ToothBrushStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

@Slf4j
@Api(tags = "Protrusion Mouth Check Controller :  돌출입 검사")
@RestController
public class ProtrusionMouthCheckController {


    private ProtrusionMouthCheckService protrusionMouthCheckService;
    public ProtrusionMouthCheckController(ProtrusionMouthCheckService protrusionMouthCheckService) { this.protrusionMouthCheckService = protrusionMouthCheckService; }

    @PostMapping("/ToothBrushStatus/{userId}")
    @ApiOperation(value="주걱턱 검사 검사" , notes = "얼굴 옆면 사진과 함께 요청하면 해당 이미지를 학습하여 그 결과 이미지를 반환한다. id폴더에 날짜로 이미지 저장")
    public ResponseEntity<ProtrusionMouthImageDto> uploadFile(@PathVariable("userId") String userId , @RequestPart MultipartFile imageFile) throws IOException{
        ProtrusionMouthImageDto protrusionMouthImageDto = protrusionMouthCheckService.protrusionMouthCheck(userId, imageFile);
        return ResponseEntity.ok(ProtrusionMouthImageDto);
    }



//    @GetMapping("/faceinfo")
//    public ResponseEntity<faceAlignDto> readfaceInfo() throws FileNotFoundException {
//        faceAlignDto facealignDto = faceAlignService.readtxtFile();
//        log.info("좌표, 점수 응답완료");
//        return ResponseEntity.status(HttpStatus.OK).body(facealignDto);
//    }
}