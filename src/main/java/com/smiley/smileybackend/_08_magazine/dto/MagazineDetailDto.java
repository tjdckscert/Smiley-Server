package com.smiley.smileybackend._08_magazine.dto;

import com.smiley.smileybackend._08_magazine.domain.Magazine;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.security.SecureRandom;

@Getter
@ToString
@NoArgsConstructor
public class MagazineDetailDto {

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
    public MagazineDetailDto(Integer id, String title, String subTitle, String author, byte[] thumbnail, Integer likes, Integer viewCount, String urlLink) {
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
    public MagazineDetailDto(Magazine saved, byte[] img) {
        SecureRandom random = new SecureRandom ();
        this.id = saved.getId();
        this.title = saved.getTitle();
        this.subTitle = saved.getSubTitle();
        this.author = saved.getAuthor();
        this.thumbnail = img;
        this.likes = random.nextInt(4000)+5000;
        this.viewCount = random.nextInt(10000)+20000;
        this.urlLink = saved.getUrlLink();
    }
}
