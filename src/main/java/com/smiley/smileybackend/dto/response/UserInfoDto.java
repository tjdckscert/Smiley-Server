package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

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

    @Builder
    public UserInfoDto(User saved) {
        this.id = saved.getId();
        this.userNumber = saved.getUserNumber();
        this.phoneToken = saved.getPhoneToken();
        this.name = saved.getName();
        this.birthDate = saved.getBirthDate();
    }
}
