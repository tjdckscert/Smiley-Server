package com.smiley.smileybackend.dto.user;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.domain.UserMedicalInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MedicalInfoDto {

    @NotBlank(message = "회원번호를 확인할 수 없습니다.")
    @ApiModelProperty(value = "사용자 회원번호(KAKAO,GOOGLE). 공백 X")
    private String userNumber;

    @NotNull(message = "교정여부를 입력해주세요")
    @ApiModelProperty(value = "사용자 교정 여부(0 or 1). 공백 X")
    private Integer calibrationStatus;

    @ApiModelProperty(value = "교정 시작일 / 입력양식은 'yyyy-mm-dd. 공백 O")
    private LocalDate startDate;

    @ApiModelProperty(value = "이용중인 병원 hPId 공백 O")
    private String hospitalhPid;

    @NotNull
    @ApiModelProperty(value = "사용자 설무조사 결과. 공백 X.")
    private List<SurveyJsonDto> surveyResult;

    public UserMedicalInfo toEntity(User user, Hospital hospital) {
        return UserMedicalInfo.builder()
                .calibrationStatus(calibrationStatus)
                .startDate(startDate)
                .surveyResult(surveyResult)
                .hospital(hospital)
                .user(user)
                .build();
    }
}
