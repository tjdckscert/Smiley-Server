package com.smiley.smileybackend._01_user.controller;

import com.smiley.smileybackend._01_user.dto.UserInfoAndMedicalInfoDto;
import com.smiley.smileybackend._01_user.dto.UserInfoDto;
import com.smiley.smileybackend._01_user.dto.UserMedicalInfoDto;
import com.smiley.smileybackend._01_user.dto.user.MedicalInfoDto;
import com.smiley.smileybackend._01_user.dto.user.UserInfoUpdateDto;
import com.smiley.smileybackend._01_user.dto.user.UserLoginDto;
import com.smiley.smileybackend._00_common.exception.ErrorCode;
import com.smiley.smileybackend._01_user.service.UserMedicalInfoService;
import com.smiley.smileybackend._01_user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "User Controller : 회원정보 및 사용자 의료정보")
@Slf4j
public class UserController {
    private final UserService userService;
    private final UserMedicalInfoService userMedicalInfoService;


    public UserController(UserService userService, UserMedicalInfoService userMedicalInfoService){
        this.userService=userService;
        this.userMedicalInfoService=userMedicalInfoService;
    }

    @GetMapping("/users/login")
    @ApiOperation(value="로그인" , notes = "사용자는 로그인한다.")
    @ApiResponse(response = ErrorCode.class, message = "등록되어 있지 않은 회원입니다.", code = 510)
        public ResponseEntity<UserInfoDto> login(@Valid @RequestParam String userNumber) {
        UserInfoDto userInfo = userService.login(userNumber);

        return ResponseEntity.ok(userInfo);
    }

    @PostMapping("/users/signup")
    @ApiOperation(value="회원가입" , notes = "사용자는 회원가입한다.")
    public ResponseEntity<UserInfoDto> signup(@Valid @RequestBody UserLoginDto userLoginDto) {
        UserInfoDto userInfo = userService.signUp(userLoginDto);
        return ResponseEntity.ok(userInfo);
    }

    @PostMapping("/users/withdrawal/{userNumber}")
    @ApiOperation(value="회원탈퇴" , notes = "사용자 번호를 회원 정보를 삭제한다.")
    @ApiResponse(response = ErrorCode.class, message = "사용자 번호를 확인할 수 없습니다.", code = 423)
    public ResponseEntity<UserInfoDto> withdrawal(@PathVariable String userNumber) {
        UserInfoDto userInfoDto = userService.withdrawal(userNumber);
        return ResponseEntity.ok(userInfoDto);
    }

    @PostMapping("/users/medicalInfo")
    @ApiOperation(value="의료 정보 저장" , notes = "사용자의 의료정보를 저장한다.")
    public ResponseEntity<UserMedicalInfoDto> medicalinfo(@Valid @RequestBody MedicalInfoDto medicalInfoDto) {
        UserMedicalInfoDto userMedicalInfoDto = userMedicalInfoService.savemedicalinfo(medicalInfoDto);
        return ResponseEntity.ok(userMedicalInfoDto);
    }

    @PatchMapping("/users/allInfo")
    @ApiOperation(value="사용자 정보 및 의료 정보" , notes = "사용자 정보 및 의료 정보를 한 번에 받아와서 저장한다.")
    public ResponseEntity<UserInfoAndMedicalInfoDto> userinfos(@Valid @RequestBody UserInfoUpdateDto userInfosDto) {
        UserInfoAndMedicalInfoDto userInfoAndMedicalInfoDto = userService.saveuserinfos(userInfosDto);
        return ResponseEntity.ok(userInfoAndMedicalInfoDto);
    }
}