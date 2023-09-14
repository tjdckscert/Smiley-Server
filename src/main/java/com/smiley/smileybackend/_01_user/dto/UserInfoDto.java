package com.smiley.smileybackend._01_user.dto;

import com.smiley.smileybackend._01_user.domain.User;
import com.smiley.smileybackend._01_user.domain.UserMedicalInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Slf4j
@NoArgsConstructor
public class UserInfoDto {

    @ApiModelProperty( example = "이메일")
    private String userNumber;

    @ApiModelProperty( example = "휴대폰 토큰")
    private String phoneToken;

    @ApiModelProperty( example = "사용자 이름")
    private String name;

    @ApiModelProperty( example = "사용자 생일")
    private LocalDate birthDate;

    @ApiModelProperty( example = "사용자 의료정보")
    private List<UserMedicalInfo> userMedicalInfos;


    @Builder
    public UserInfoDto(String userNumber, String phoneToken, String name, LocalDate birthDate, List<UserMedicalInfo> userMedicalInfos) {
        this.userNumber = userNumber;
        this.phoneToken = phoneToken;
        this.name = name;
        this.birthDate = birthDate;
        this.userMedicalInfos = userMedicalInfos;
    }

    public UserInfoDto(User user) {
        this.userNumber = user.getUserNumber();
        this.phoneToken = user.getPhoneToken();
        this.name = user.getName();
        this.birthDate = user.getBirthDate();
        this.userMedicalInfos = user.getUserUserMedicalInfos();
    }
}
