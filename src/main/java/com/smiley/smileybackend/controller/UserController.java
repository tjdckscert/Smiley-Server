package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.UserInfoDto;
import com.smiley.smileybackend.dto.response.UserMedicalInfoDto;
import com.smiley.smileybackend.dto.user.MedicalInfoDto;
import com.smiley.smileybackend.dto.user.UserLoginDto;
import com.smiley.smileybackend.service.UserMedicalInfoService;
import com.smiley.smileybackend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = "User Controller : 회원정보 및 사용자 의료정보")
@Slf4j
public class UserController {
    private UserService userService;
    private UserMedicalInfoService userMedicalInfoService;

    public UserController(UserService userService, UserMedicalInfoService userMedicalInfoService){
        this.userService=userService;
        this.userMedicalInfoService=userMedicalInfoService;
    }

    @PostMapping("/users/login")
    @ApiOperation(value="로그인" , notes = "사용자는 로그인한다.")
    public ResponseEntity<UserInfoDto> login(@Valid @RequestBody UserLoginDto userLoginDto) {
        UserInfoDto userInfo = userService.login(userLoginDto);
        return ResponseEntity.ok(userInfo);
    }

    @PostMapping("/users/medicalinfo")
    @ApiOperation(value="로그인" , notes = "사용자의 의료정보를 저장한다.")
    public ResponseEntity<UserMedicalInfoDto> login(@Valid @RequestBody MedicalInfoDto medicalInfoDto) {
        UserMedicalInfoDto userMedicalInfoDto = userMedicalInfoService.savemedicalinfo(medicalInfoDto);
        return ResponseEntity.ok(userMedicalInfoDto);
    }
}