package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.UserMedicalInfo;
import com.smiley.smileybackend.dto.user.SurveyJsonDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Slf4j
@ToString
@NoArgsConstructor
public class UserMedicalInfoDto {
    @ApiModelProperty( example = "인덱스/Integer")
    private Integer id;
    @ApiModelProperty( example = "교정여부")
    private Integer calibrationStatus;
    @ApiModelProperty( example = "교정시작일")
    private LocalDate startDate;
    @ApiModelProperty( example = "설문조사결과/List<Json>")
    private List<SurveyJsonDto> surveyResult;

    @Builder
    public UserMedicalInfoDto(UserMedicalInfo saved) {
        this.id = saved.getId();
        this.calibrationStatus = saved.getCalibrationStatus();
        this.startDate = saved.getStartDate();
        this.surveyResult = saved.getSurveyResult();
    }


}
