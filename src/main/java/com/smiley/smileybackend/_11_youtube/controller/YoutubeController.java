package com.smiley.smileybackend._11_youtube.controller;

import com.smiley.smileybackend._00_common.exception.ErrorCode;
import com.smiley.smileybackend._08_magazine.dto.MagazineDetailDto;
import com.smiley.smileybackend._08_magazine.dto.MagazineInfoDtoList;
import com.smiley.smileybackend._08_magazine.service.MagazineService;
import com.smiley.smileybackend._11_youtube.dto.YoutubeInfoDtoList;
import com.smiley.smileybackend._11_youtube.service.YoutubeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Youtube Controller : 유튜브 추천 영상 정보")
public class YoutubeController {
    private final YoutubeService youtubeService;
    public YoutubeController(YoutubeService youtubeService){
        this.youtubeService=youtubeService;
    }

    @GetMapping("/youtube")
    @ApiOperation(value="모든 영상" , notes = "모든 영상 정보를 반환한다.")
    public ResponseEntity<YoutubeInfoDtoList> Videos(@RequestParam(value = "page",defaultValue = "0") Integer page, @RequestParam(value = "size",defaultValue = "5") Integer size){
        YoutubeInfoDtoList videos = youtubeService.getAll(page,size);
        return ResponseEntity.ok(videos);

    }
    @GetMapping("/youtube/recommend")
    @ApiOperation(value="추천 영상" , notes = "선택한 수량만큼의 매거진 정보를 반환한다.")
    public ResponseEntity<YoutubeInfoDtoList> numberOfVideos(@RequestParam("number") Integer number){
        YoutubeInfoDtoList videos = youtubeService.getListOfNumber(number);
        return ResponseEntity.ok(videos);
    }

}