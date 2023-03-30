package com.smiley.smileybackend.dto.user;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SurveyJsonDto {

    @NotBlank(message = "질문을 입력해주세요")
    @ApiModelProperty(value = "설문조사 질문")
    private String question;

    @NotBlank(message = "응답을 입력해주세요")
    @ApiModelProperty(value = "설문조사 응답")
    private String answer;

    @ApiModelProperty(value = "설문조사 응답에 대한 상세설명, 공백 O / ex : 먹고있는 약은 ->타이레놀,이지엔6")
    private String detail;
}
