package com.smiley.smileybackend.dto.response;

import io.swagger.annotations.ApiModelProperty;

public class ToothBrushImageDto {

    @ApiModelProperty( example = "이미지파일")
    private byte[] image;
}
