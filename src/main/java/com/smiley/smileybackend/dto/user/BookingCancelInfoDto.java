package com.smiley.smileybackend.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class BookingCancelInfoDto {

    @NotNull
    @ApiModelProperty(value = "예약 번호(index), 공백 x")
    private Integer id;

    @NotNull
    @ApiModelProperty(value = "사용자 번호(index), 공백 x")
    private Integer userId;
}
