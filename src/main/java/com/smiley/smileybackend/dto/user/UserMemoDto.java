package com.smiley.smileybackend.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Setter
public class UserMemoDto {

    @NotNull(message = "메모를 입력할 예약을 선택해 주세요")
    @ApiModelProperty(value = "예약 번호, 공백 X")
    private Integer id;

    @ApiModelProperty(value = "입력할 메모 정보, 공백 O")
    private String memo;

    @Builder
    public UserMemoDto(Integer id, String memo) {
        this.id = id;
        this.memo = memo;
    }
}
