package com.smiley.smileybackend._01_user.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ExpJsonDto {

    @ApiModelProperty(value = "회득경로")
    private String title;


    @ApiModelProperty(value = "경험치량")
    private Integer exp;

    @Builder
    public ExpJsonDto(String title, Integer exp) {
        this.title = title;
        this.exp = exp;
    }
}
