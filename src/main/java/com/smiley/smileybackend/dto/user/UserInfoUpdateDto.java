package com.smiley.smileybackend.dto.user;

import com.smiley.smileybackend.domain.Hospital;
import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.domain.UserMedicalInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoUpdateDto {
    
    @ApiModelProperty(value = "업데이트시 사용자 Id(index) 확인용으로 사용.")
    private Integer id;

    @NotBlank(message = "회원번호를 확인할 수 없습니다.")
    @ApiModelProperty(value = "사용자 회원번호(KAKAO,GOOGLE). 공백 X")
    private String userNumber;

    @ApiModelProperty(value = "사용자 휴대폰 토큰값. 공백 X")
    private String phoneToken;

    @NotBlank(message = "이름을 입력해주세요, 공백 X")
    @ApiModelProperty(value = "사용자 이름확인. 공백 X")
    private String name;

    @NotNull(message = "교정여부를 입력해주세요")
    @ApiModelProperty(value = "사용자 교정 여부(0 or 1). 공백 X")
    private Integer calibrationStatus;

    @ApiModelProperty(value = "교정 시작일 / 입력양식은 'yyyy-mm-dd. 공백 O")
    private LocalDate startDate;

    @ApiModelProperty(value = "이용중인 병원 hPId 공백 O")
    private String hPId;

    @NotNull
    @ApiModelProperty(value = "사용자 설문 조사 결과. 공백 X.")
    private List<SurveyJsonDto> surveyResult;

    @NotNull(message = "생년월일 입력해주세요, 공백 X")
    @PastOrPresent
    @ApiModelProperty(value = "사용자 생년월일 확인 / 입력 양식은 'yyyy-mm-dd' . 공백 X. NOW보다 과거의 날짜만 가능하다.")
    private LocalDate birthDate;

    public User toUserEntity() {
        return User.builder()
                .userNumber(userNumber)
                .phoneToken(phoneToken)
                .name(name)
                .birthDate(birthDate)
                .build();
    }

    public UserMedicalInfo toUserMedicalInfoEntity(User user, Hospital hospital) {
        return UserMedicalInfo.builder()
                .calibrationStatus(calibrationStatus)
                .startDate(startDate)
                .surveyResult(surveyResult)
                .hospital(hospital)
                .user(user)
                .build();
    }
}
