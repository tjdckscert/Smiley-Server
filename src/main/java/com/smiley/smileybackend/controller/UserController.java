package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.UserInfo;
import com.smiley.smileybackend.dto.response.UserMedicalInfoSave;
import com.smiley.smileybackend.dto.user.MedicalInfo;
import com.smiley.smileybackend.dto.user.UserLogin;
import com.smiley.smileybackend.service.UserMedicalInfoService;
import com.smiley.smileybackend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = "User Controller : 회원정보 및 사용자 의료정보")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMedicalInfoService userMedicalInfoService;

    @PostMapping("/users/login")
    @ApiOperation(value="로그인" , notes = "사용자는 로그인한다.")
    public ResponseEntity<UserInfo> login(@Valid @RequestBody UserLogin userLogin) {
        UserInfo userInfo = userService.login(userLogin);
        return ResponseEntity.ok(userInfo);
    }

    @PostMapping("/users/medicalinfo")
    @ApiOperation(value="로그인" , notes = "사용자의 의료정보를 저장한다.")
    public ResponseEntity<UserMedicalInfoSave> login(@Valid @RequestBody MedicalInfo medicalInfo) {
        UserMedicalInfoSave userMedicalInfoSave = userMedicalInfoService.savemedicalinfo(medicalInfo);
        return ResponseEntity.ok(userMedicalInfoSave);
    }
}