package com.smiley.smileybackend._01_user.dto;

import com.smiley.smileybackend._01_user.dto.user.SurveyJsonDto;
import com.smiley.smileybackend._01_user.dto.user.UserInfoUpdateDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@NoArgsConstructor
@Getter
@ToString
@Setter
public class UserInfoAndMedicalInfoDto {

    @ApiModelProperty( example = "사용자 ID")
    private String userNumber;

    @ApiModelProperty( example = "이메일")
    private String email;

    @ApiModelProperty( example = "휴대폰 토큰")
    private String phoneToken;

    @ApiModelProperty( example = "사용자 이름")
    private String name;

    @ApiModelProperty( example = "사용자 생일")
    private LocalDate bitrhDate;

    @ApiModelProperty( example = "교정여부")
    private Integer calibrationStatus;

    @ApiModelProperty( example = "교정시작일")
    private LocalDate startDate;

    @ApiModelProperty( example = "설문조사결과/List<Json>")
    private List<SurveyJsonDto> surveyResult;

    @Builder
    public UserInfoAndMedicalInfoDto(UserInfoUpdateDto saved) {
        this.userNumber = saved.getUserNumber();
        this.email = saved.getUserNumber();
        this.phoneToken = saved.getPhoneToken();
        this.name = saved.getName();
        this.bitrhDate = saved.getBirthDate();
        this.calibrationStatus = saved.getCalibrationStatus();
        this.startDate = saved.getStartDate();
        this.surveyResult = saved.getSurveyResult();
    }

}
