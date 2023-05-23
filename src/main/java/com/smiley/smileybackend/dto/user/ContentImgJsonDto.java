package com.smiley.smileybackend.dto.user;

import com.smiley.smileybackend.domain.enums.ContentType;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@NoArgsConstructor
@ToString
@Setter
public class ContentImgJsonDto {
    @ApiModelProperty(value = "타입(본문,5분요약,핵심요약)")
    private ContentType contentType;

    @ApiModelProperty(value = "이미지 주소(서버)")
    private byte[] img;

    @ApiModelProperty(value = "내용")
    private String content;

    @Builder
    public ContentImgJsonDto(ContentType contentType, byte[] img, String content) {
        this.contentType = contentType;
        this.img = img;
        this.content = content;
    }
}
