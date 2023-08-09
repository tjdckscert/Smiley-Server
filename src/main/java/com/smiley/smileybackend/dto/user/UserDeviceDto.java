package com.smiley.smileybackend.dto.user;

import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.domain.UserDevice;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@NoArgsConstructor
@Setter
public class UserDeviceDto{

        @NotBlank(message = "회원번호를 확인할 수 없습니다.")
        @ApiModelProperty(value = "사용자 회원번호(KAKAO,GOOGLE). 공백 X")
        private String userNumber;
        @NotBlank(message = "장치이름은 빈 칸일 수 없습니다.")
        @ApiModelProperty(value = "장치 이름")
        private String deviceName;

        @NotBlank(message = "장치타입을 선택해주세요.")
        @ApiModelProperty(value = "장치 타입 ( 주걱턱 or 유지 장치 )")
        private String deviceType;

        @ApiModelProperty(value = "장치 토큰(장치일련번호)")
        private String deviceUuid;

        @ApiModelProperty(value = "마지막으로 통신한 용자 유지 장치의 X 좌표")
        private String cordX;

        @ApiModelProperty(value = "마지막으로 통신한 사용자 유지 장치의 Y 좌표")
        private String cordY;

        @Builder
        public UserDeviceDto(String userNumber, String deviceName, String deviceType, String deviceUuid, String cordX, String cordY) {
                this.userNumber = userNumber;
                this.deviceName = deviceName;
                this.deviceType = deviceType;
                this.deviceUuid = deviceUuid;
                this.cordX = cordX;
                this.cordY = cordY;
        }

        public UserDevice toEntity(User user) {
            return UserDevice.builder()
                    .user(user)
                    .deviceName(deviceName)
                    .deviceType(deviceType)
                    .deviceUuid(deviceUuid)
                    .cordX(cordX)
                    .cordY(cordY)
                    .build();
        }
}
