package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.UserDeviceInfoDto;
import com.smiley.smileybackend.dto.user.UserDeviceDto;
import com.smiley.smileybackend.service.UserDeviceService;
import io.swagger.annotations.Api;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@ToString
@Slf4j
@Api(tags = "UserDevice Controller : 사용자 유지 장치 정보")
public class UserDeviceController {
    private final UserDeviceService userDeviceSerivce;

    public UserDeviceController(UserDeviceService userDeviceService){
        this.userDeviceSerivce=userDeviceService;
    }

    @PostMapping("/userdevices/adddevice")
    public ResponseEntity<UserDeviceInfoDto> adddevice(@Valid @RequestBody UserDeviceDto userDeviceDto){
        log.info(userDeviceDto.toString());
        UserDeviceInfoDto UserDeviceInfoDto= userDeviceSerivce.adddevice(userDeviceDto);

        return ResponseEntity.ok(UserDeviceInfoDto);
    }
}
