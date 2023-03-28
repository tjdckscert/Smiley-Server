package com.smiley.smileybackend.controller;


import com.smiley.smileybackend.dto.response.UserInfo;
import com.smiley.smileybackend.dto.user.UserLogin;
import com.smiley.smileybackend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
//@RequiredArgsConstructor
@Api(tags = "Member Controller : 회원, 조교...")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users/login")
    @ApiOperation(value="로그인" , notes = "사용자는 로그인한다.")
    public ResponseEntity<UserInfo> login(@Valid @RequestBody UserLogin userLogin) {
        log.info(userLogin.toString());
        UserInfo userInfo = userService.login(userLogin);
        log.info(userInfo.toString());
        return ResponseEntity.ok(userInfo);
    }
}