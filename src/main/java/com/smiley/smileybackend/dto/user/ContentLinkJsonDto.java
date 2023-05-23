package com.smiley.smileybackend.dto.user;

import com.smiley.smileybackend.domain.enums.ContentType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ContentLinkJsonDto {
    @ApiModelProperty(value = "타입(본문,5분요약,핵심요약)")
    private ContentType contentType;

    @ApiModelProperty(value = "이미지 주소(서버)")
    private String imgLink;

    @ApiModelProperty(value = "내용")
    private String content;

    @Builder
    public ContentLinkJsonDto(ContentType contentType, String imgLink, String content) {
        this.contentType = contentType;
        this.imgLink = imgLink;
        this.content = content;
    }
}
