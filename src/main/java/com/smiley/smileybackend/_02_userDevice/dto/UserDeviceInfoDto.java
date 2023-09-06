package com.smiley.smileybackend._02_userDevice.dto;

import com.smiley.smileybackend._02_userDevice.domain.UserDevice;
import lombok.*;

@NoArgsConstructor
@Getter
@ToString
@Setter
public class UserDeviceInfoDto {

    private Integer id;

    private String userNumber;

    private String deviceName;

    private String deviceType;

    private String deviceUuid;

    private String cordX;

    private String cordY;

    @Builder
    public UserDeviceInfoDto(Integer id, String userNumber, String deviceName, String deviceType, String deviceUuid, String cordX, String cordY) {
        this.id = id;
        this.userNumber = userNumber;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.deviceUuid = deviceUuid;
        this.cordX = cordX;
        this.cordY = cordY;
    }
    @Builder
    public UserDeviceInfoDto(UserDevice saved) {
        this.id=saved.getId();
        this.userNumber= saved.getUser().getUserNumber();
        this.deviceName = saved.getDeviceName();
        this.deviceType= saved.getDeviceType();
        this.deviceUuid= saved.getDeviceUuid();
        this.cordX= saved.getCordX();
        this.cordY= saved.getCordY();

    }
}
