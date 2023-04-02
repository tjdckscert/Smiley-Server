package com.smiley.smileybackend.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@NoArgsConstructor
public class MedicineIdDto {
    @NotNull(message = "의약품 Id를 입력해주세요")
    @ApiModelProperty(value = "의약품 ID. 공백 X")
    private Integer id;
}
