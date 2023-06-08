package com.smiley.smileybackend.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AnyDayWearTimeDto {

    @NotNull
    @ApiModelProperty(value = "사용자 ID(user의 index번호). 공백 X")
    private Integer userId;

    @NotNull(message = "날짜를 선택해 주세요")
    @ApiModelProperty(value = "착용 시간을 찾기 원하는 날짜")
    private LocalDate wearDate;
}
