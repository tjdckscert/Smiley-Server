package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.UserDevice;
import lombok.*;

@NoArgsConstructor
@Getter
@ToString
@Setter
public class UserDeviceInfoDto {

    private Integer id;

    private Integer userId;

    private String deviceName;

    private String deviceType;

    private String deviceUuid;

    private String cordX;

    private String cordY;

    @Builder
    public UserDeviceInfoDto(Integer id, Integer userId, String deviceName, String deviceType, String deviceUuid, String cordX, String cordY) {
        this.id = id;
        this.userId = userId;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.deviceUuid = deviceUuid;
        this.cordX = cordX;
        this.cordY = cordY;
    }
    @Builder
    public UserDeviceInfoDto(UserDevice saved) {
        this.id=saved.getId();
        this.userId= saved.getUser().getId();
        this.deviceName = saved.getDeviceName();
        this.deviceType= saved.getDeviceType();
        this.deviceUuid= saved.getDeviceUuid();
        this.cordX= saved.getCordX();
        this.cordY= saved.getCordY();

    }
}
