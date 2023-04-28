package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.DailyExpStasticsInfoDto;
import com.smiley.smileybackend.dto.response.DailyWearTimeInfoDto;
import com.smiley.smileybackend.dto.response.TotalExpStasticsInfoDto;
import com.smiley.smileybackend.dto.user.DailyWearTimeDto;
import com.smiley.smileybackend.repository.TotalExpStasticsRepository;
import com.smiley.smileybackend.service.DailyExpStasticsService;
import com.smiley.smileybackend.service.DailyWearTimeService;
import com.smiley.smileybackend.service.TotalExpStasticsService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = "DailyWearTime Controller : 일일 착용 정보")
public class DailyWearTimeController {
    private final DailyWearTimeService dailyWearTimeService;

    private final DailyExpStasticsService dailyExpStasticsService;

    private final TotalExpStasticsService totalExpStasticsService;

    public DailyWearTimeController(DailyWearTimeService dailyWearTimeService, DailyExpStasticsService dailyExpStasticsService, TotalExpStasticsService totalExpStasticsService) {
        this.dailyWearTimeService = dailyWearTimeService;
        this.dailyExpStasticsService = dailyExpStasticsService;
        this.totalExpStasticsService = totalExpStasticsService;
    }

    @PostMapping("/dailyweartimes/todayweartime")
    public ResponseEntity<TotalExpStasticsInfoDto> todayweartime(@Valid @RequestBody DailyWearTimeDto dailyWearTimeDto){
        DailyWearTimeInfoDto dailyWearTimeInfoDto =  dailyWearTimeService.saveWearTime(dailyWearTimeDto);
        //경험치 저장 service 호출
        DailyExpStasticsInfoDto dailyExpStasticsInfoDto = dailyExpStasticsService.saveExp(dailyWearTimeDto);
        //총 경험치 저장 service 호출
        TotalExpStasticsInfoDto totalExpStasticsInfoDto = totalExpStasticsService.saveTotalExp(dailyWearTimeDto);
        return ResponseEntity.ok(totalExpStasticsInfoDto);
    }
}

