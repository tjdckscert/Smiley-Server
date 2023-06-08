package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.*;
import com.smiley.smileybackend.dto.response.dtolist.LastSevenDaysWearTimeDtoList;
import com.smiley.smileybackend.dto.user.SpecificDateWearTimeDto;
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
    public ResponseEntity<TotalExpStasticsInfoDto> todayweartime(@Valid @RequestBody DailyWearTimeDto dailyWearTimeDto){
        DailyWearTimeInfoDto dailyWearTimeInfoDto =  dailyWearTimeService.saveWearTime(dailyWearTimeDto);
        //경험치 저장 service 호출
        DailyExpStasticsInfoDto dailyExpStasticsInfoDto = dailyExpStasticsService.saveExp(dailyWearTimeDto);
        //총 경험치 저장 service 호출
        TotalExpStasticsInfoDto totalExpStasticsInfoDto = totalExpStasticsService.saveTotalExp(dailyWearTimeDto);
        return ResponseEntity.ok(totalExpStasticsInfoDto);
    }

    @GetMapping("/dailyWearTimes/lastSevenDays/{id}")
    public ResponseEntity<LastSevenDaysWearTimeDtoList> lastSevenDays(@PathVariable Integer id){
        LastSevenDaysWearTimeDtoList lastSevenDaysWearTimeDtoList =  dailyWearTimeService.getLastSevenDayWearTime(id);
        return ResponseEntity.ok(lastSevenDaysWearTimeDtoList);
    }

    @PostMapping("/dailyWearTimes/day")
    public ResponseEntity<UserSpecificDateWearTimeDto> anydayweartime(@Valid@RequestBody SpecificDateWearTimeDto specificDateWearTimeDto){
        UserSpecificDateWearTimeDto userSpecificDateWearTimeDto =  dailyWearTimeService.getAnyDayWearTime(specificDateWearTimeDto);
        return ResponseEntity.ok(userSpecificDateWearTimeDto);
    }

    /**
    *Testing Open(#96)
    * */
    @GetMapping("/dailyWearTimes/dayInformation")
    @ApiOperation(value="날짜를 입력" , notes = "입력한 날짜의 데이트를 반환")
    public ResponseEntity<TestDateDto> anydayweartime(@RequestParam String day){
        TestDateDto testDateDto = dailyWearTimeService.getTodayInfor(day);
        return ResponseEntity.ok(testDateDto);
    }
}

