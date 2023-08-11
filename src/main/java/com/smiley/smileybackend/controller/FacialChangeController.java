package com.smiley.smileybackend.controller;


import com.smiley.smileybackend.dto.response.FacialChangeImageDto;
import com.smiley.smileybackend.service.FacialChangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Api(tags = "Protrusion Mouth Check Controller :  돌출입 검사")
@RestController
public class FacialChangeController {


    private FacialChangeService facialChangeService;

    public FacialChangeController(FacialChangeService facialChangeService) {
        this.facialChangeService = facialChangeService;
    }

    @PostMapping("/FacialChange/{userId}")
    @ApiOperation(value = "주걱턱 검사 검사", notes = "얼굴 옆면 사진과 함께 요청하면 해당 이미지를 학습하여 그 결과 이미지를 반환한다. id폴더에 날짜로 이미지 저장")
    public ResponseEntity<FacialChangeImageDto> uploadFile(@PathVariable("userId") String userId, @RequestPart MultipartFile imageFile) throws IOException {
        FacialChangeImageDto facialChangeImageDto = facialChangeService.facialChangeCheck(userId, imageFile);
        return ResponseEntity.ok(facialChangeImageDto);
    }

    @GetMapping("/FacialChange/{userId}/{date}")
    @ApiOperation(value = "해당 날짜 주걱턱 기록 가져오기", notes = "해당 날짜(2023-08-02)에 저장되어 있는 이미지 가져오기")
    public ResponseEntity<FacialChangeImageDto> getImageFile(@PathVariable("userId") String userId, @PathVariable("date") String date){
        FacialChangeImageDto facialChangeImageDto = facialChangeService.getTrainedFile(userId, date);
        return ResponseEntity.ok(facialChangeImageDto);
    }


    @DeleteMapping("/FacialChange/{userId}/{date}")
    @ApiOperation(value = "해당 날짜 주걱턱 기록 삭제하기", notes = "해당 날짜(2023-08-02)에 저장되어 있는 이미지 삭제하기 true:삭제 성공 false:삭제할파일없음")
    public boolean deleteImageFile(@PathVariable("userId") String userId, @PathVariable("date") String date){
        boolean status = facialChangeService.deleteTrainedFile(userId, date);

        return status;

    }
}

