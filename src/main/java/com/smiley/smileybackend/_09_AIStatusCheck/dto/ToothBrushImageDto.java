package com.smiley.smileybackend._09_AIStatusCheck.dto;

import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ToothBrushImageDto{
    @ApiModelProperty( example = "이미지파일")
    private byte[] image;


}
