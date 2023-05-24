package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.domain.UserMedicalInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

@Data
@Slf4j
@NoArgsConstructor
public class UserInfoDto {
    @ApiModelProperty( example = "인덱스/Integer")
    private Integer id;

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
    public UserInfoDto(Integer id, String userNumber, String phoneToken, String name, LocalDate birthDate, List<UserMedicalInfo> userMedicalInfos) {
        this.id = id;
        this.userNumber = userNumber;
        this.phoneToken = phoneToken;
        this.name = name;
        this.birthDate = birthDate;
        this.userMedicalInfos = userMedicalInfos;
    }

    public UserInfoDto entityToDto(User user) {
        return new UserInfoDto(
                user.getId(),
                user.getUserNumber(),
                user.getPhoneToken(),
                user.getName(),
                user.getBirthDate(),
                user.getUserUserMedicalInfos()
        );

    }
}
