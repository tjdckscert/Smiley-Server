package com.smiley.smileybackend.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@ToString
public class HospitalIdDto {

    @NotNull(message = "병원 Id를 입력해주세요")
    @ApiModelProperty(value = "병원 ID. 공백 X")
    private Integer hospitalId;
}
