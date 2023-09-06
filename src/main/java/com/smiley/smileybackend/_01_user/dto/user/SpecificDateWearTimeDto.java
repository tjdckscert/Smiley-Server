package com.smiley.smileybackend._01_user.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SpecificDateWearTimeDto {

    @NotBlank(message = "회원번호를 확인할 수 없습니다.")
    @ApiModelProperty(value = "사용자 회원번호(KAKAO,GOOGLE). 공백 X")
    private String userNumber;

    @NotNull(message = "날짜를 선택해 주세요")
    @ApiModelProperty(value = "착용 시간을 찾기 원하는 날짜")
    private LocalDate wearDate;

    @Builder
    public SpecificDateWearTimeDto(String userNumber, LocalDate wearDate) {
        this.userNumber = userNumber;
        this.wearDate = wearDate;
    }
}
