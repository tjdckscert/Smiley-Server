package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.TestDateDto;
import com.smiley.smileybackend.dto.response.UserSpecificDateWearTimeDto;
import com.smiley.smileybackend.dto.user.SpecificDateWearTimeDto;
import com.smiley.smileybackend.service.StateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "State Controller : 사용자 경험치 및 착용 시간 상태 정보")
public class StateController {
    private final StateService stateService;

    public StateController(StateService stateService){
        this.stateService=stateService;
    }
    @PostMapping("/state/day")
    @ApiOperation(value="특정 날짜의 착용데이터 및 총 경험치량을 반환한다." , notes = "입력한 날짜의 데이터를 반환")
    public ResponseEntity<UserSpecificDateWearTimeDto> anydayweartime(@Valid @RequestBody SpecificDateWearTimeDto specificDateWearTimeDto){
        UserSpecificDateWearTimeDto userSpecificDateWearTimeDto =  stateService.getAnyDayWearTime(specificDateWearTimeDto);
        return ResponseEntity.ok(userSpecificDateWearTimeDto);
    }

    /**
     *Testing Open(#96)
     * */
    @GetMapping("/state/{day}")
    @ApiOperation(value="특정 날짜의 착용데이터 및 총 경험치량을 반환한다.(Test)" , notes = "입력한 날짜의 데이터를 반환(Test)")
    public ResponseEntity<TestDateDto> anydayweartime(@PathVariable String day){
        TestDateDto testDateDto = stateService.getTodayInfor(day);
        return ResponseEntity.ok(testDateDto);
    }

}
