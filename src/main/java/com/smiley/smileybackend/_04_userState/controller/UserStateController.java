package com.smiley.smileybackend._04_userState.controller;

import com.smiley.smileybackend._04_userState.dto.TestDateDto;
import com.smiley.smileybackend._04_userState.dto.UserSpecificDateWearTimeDto;
import com.smiley.smileybackend._01_user.dto.user.SpecificDateWearTimeDto;
import com.smiley.smileybackend._04_userState.service.UserStateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "State Controller : 사용자 경험치 및 착용 시간 상태 정보")
public class UserStateController {
    private final UserStateService userStateService;

    public UserStateController(UserStateService userStateService){
        this.userStateService = userStateService;
    }
    @PostMapping("/state/day")
    @ApiOperation(value="특정 날짜의 착용데이터 및 총 경험치량을 반환한다." , notes = "입력한 날짜의 데이터를 반환")
    public ResponseEntity<UserSpecificDateWearTimeDto> anydayweartime(@Valid @RequestBody SpecificDateWearTimeDto specificDateWearTimeDto){
        UserSpecificDateWearTimeDto userSpecificDateWearTimeDto =  userStateService.getAnyDayWearTime(specificDateWearTimeDto);
        return ResponseEntity.ok(userSpecificDateWearTimeDto);
    }

    /**
     *Testing Open(#96)
     * */
    @GetMapping("/state/{day}")
    @ApiOperation(value="특정 날짜의 착용데이터 및 총 경험치량을 반환한다.(Test)" , notes = "입력한 날짜의 데이터를 반환(Test)")
    public ResponseEntity<TestDateDto> anydayweartime(@PathVariable String day){
        TestDateDto testDateDto = userStateService.getTodayInfor(day);
        return ResponseEntity.ok(testDateDto);
    }

}
