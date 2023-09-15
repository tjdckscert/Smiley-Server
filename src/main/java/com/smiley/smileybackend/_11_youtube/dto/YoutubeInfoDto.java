package com.smiley.smileybackend._11_youtube.dto;

import com.smiley.smileybackend._11_youtube.domain.Youtube;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Getter
@ToString
@NoArgsConstructor
public class YoutubeInfoDto {
    @ApiModelProperty( example = "인덱스/Integer")
    Integer id;
    @ApiModelProperty( example = "제목")
    String title;
    @ApiModelProperty( example = "썸네일")
    byte[] thumbnail;
    @ApiModelProperty( example = "링크주소")
    String urlLink;

    @Builder
    public YoutubeInfoDto(Integer id, String title, byte[] thumbnail, String urlLink) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.urlLink = urlLink;
    }

    @Builder
    public static YoutubeInfoDto entityToDto(Youtube youtube)  {
        InputStream inputStream = null;
        byte[] thumbnailImg;
        try {
            inputStream = new FileInputStream(youtube.getThumbnail());
            long fileSize = new File(youtube.getThumbnail()).length();
            thumbnailImg = new byte[(int) fileSize];
            while (inputStream.read(thumbnailImg)>0);
            inputStream.close();
        } catch ( IOException e) {
            throw new RuntimeException(e);
        }
        return new YoutubeInfoDto(
                youtube.getId(),
                youtube.getTitle(),
                thumbnailImg,
                youtube.getUrlLink());
    }
}