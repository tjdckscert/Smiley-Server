package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.UserDeviceInfoDto;
import com.smiley.smileybackend.dto.user.UserDeviceDto;
import com.smiley.smileybackend.service.UserDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
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

    @PostMapping("/userDevices")
    @ApiOperation(value="장치 추가" , notes = "사용자의 장치를 추가한다")
    @ApiResponse(message = "1. 사용자를 찾을 수 없습니다 \t\n\n 2. 디바이스가 이미 등록되어 있습니다.", code= 400)
    public ResponseEntity<UserDeviceInfoDto> adddevice(@Valid @RequestBody UserDeviceDto userDeviceDto){
        log.info(userDeviceDto.toString());
        UserDeviceInfoDto UserDeviceInfoDto= userDeviceSerivce.adddevice(userDeviceDto);

        return ResponseEntity.ok(UserDeviceInfoDto);
    }
}
