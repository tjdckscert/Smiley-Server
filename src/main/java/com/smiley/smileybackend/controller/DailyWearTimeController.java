package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.annotation.AchievementsAnnotation;
import com.smiley.smileybackend.annotation.WearTimeAchievementsAnnotation;
import com.smiley.smileybackend.dto.response.*;
import com.smiley.smileybackend.dto.response.dtolist.LastSevenDaysWearTimeDtoList;
import com.smiley.smileybackend.dto.user.DailyWearTimeDto;
import com.smiley.smileybackend.service.DailyExpStasticsService;
import com.smiley.smileybackend.service.DailyWearTimeService;
import com.smiley.smileybackend.service.TotalExpStasticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/dailyWearTimes")
    @AchievementsAnnotation(badgeName = {"exp","time","day"})
    @WearTimeAchievementsAnnotation
    @ApiOperation(value="착용 시간 저장" , notes = "사용자의 일일 착용 시간 정보를 저장한다.")
    public ResponseEntity<TotalExpStasticsInfoDto> todayweartime(@Valid @RequestBody DailyWearTimeDto dailyWearTimeDto){
        DailyWearTimeInfoDto dailyWearTimeInfoDto =  dailyWearTimeService.saveWearTime(dailyWearTimeDto);
        //경험치 저장 service 호출
        DailyExpStasticsInfoDto dailyExpStasticsInfoDto = dailyExpStasticsService.saveExp(dailyWearTimeDto);
        //총 경험치 저장 service 호출
        TotalExpStasticsInfoDto totalExpStasticsInfoDto = totalExpStasticsService.saveTotalExp(dailyWearTimeDto);
        return ResponseEntity.ok(totalExpStasticsInfoDto);
    }

    @GetMapping("/dailyWearTimes/lastSevenDays/{id}")
    @ApiOperation(value="최근 일주일 착용정보" , notes = "사용자의 최근 1주일 착용 정보를 가져 와서 반환 한다.")
    public ResponseEntity<LastSevenDaysWearTimeDtoList> lastSevenDays(@PathVariable Integer id){
        LastSevenDaysWearTimeDtoList lastSevenDaysWearTimeDtoList =  dailyWearTimeService.getLastSevenDayWearTime(id);
        return ResponseEntity.ok(lastSevenDaysWearTimeDtoList);
    }

}

