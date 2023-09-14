package com.smiley.smileybackend._08_magazine.dto;

import com.smiley.smileybackend._08_magazine.domain.Magazine;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.*;

@Getter
@ToString
@NoArgsConstructor
public class MagazineInfoDto {
    @ApiModelProperty( example = "인덱스/Integer")
    Integer id;
    @ApiModelProperty( example = "제목")
    String title;
    @ApiModelProperty( example = "부제목")
    String subTitle;
    @ApiModelProperty( example = "작성자")
    String author;
    @ApiModelProperty( example = "썸네일")
    byte[] thumbnail;
    @ApiModelProperty( example = "좋아요")
    Integer likes;
    @ApiModelProperty( example = "읽은수")
    Integer viewCount;
    @ApiModelProperty( example = "링크주소")
    String urlLink;

    @Builder
    public MagazineInfoDto(Integer id, String title, String subTitle, String author, byte[] thumbnail, Integer likes, Integer viewCount, String urlLink) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.thumbnail = thumbnail;
        this.likes = likes;
        this.viewCount = viewCount;
        this.urlLink = urlLink;
    }

    @Builder
    public static MagazineInfoDto entityToDto(Magazine magazine)  {
        InputStream inputStream = null;
        byte[] thumbnailImg;
        try {
            inputStream = new FileInputStream(magazine.getThumbnail());
            long fileSize = new File(magazine.getThumbnail()).length();
            thumbnailImg = new byte[(int) fileSize];
            while (inputStream.read(thumbnailImg)>0);
            inputStream.close();
        } catch ( IOException e) {
            throw new RuntimeException(e);
        }
        return new MagazineInfoDto(
                magazine.getId(),
                magazine.getTitle(),
                magazine.getSubTitle(),
                magazine.getAuthor(),
                thumbnailImg,
                magazine.getLikes(),
                magazine.getViewCount(),
                magazine.getUrlLink());
    }
}
