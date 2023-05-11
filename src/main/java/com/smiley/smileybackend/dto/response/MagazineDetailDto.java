package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Magazine;
import com.smiley.smileybackend.dto.user.ContentImgJsonDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;
import java.util.Random;

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
    String thumbnail;
    @ApiModelProperty( example = "좋아요")
    Integer likes;
    @ApiModelProperty( example = "읽은수")
    Integer viewCount;

    @ApiModelProperty( example = "메인컨텐트")
    List<ContentImgJsonDto> mainContent;

    @Builder
    public MagazineDetailDto(Integer id, String title, String subTitle, String author, String thumbnail, Integer likes, Integer viewCount, List<ContentImgJsonDto> mainContent) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.thumbnail = thumbnail;
        this.likes = likes;
        this.viewCount = viewCount;
        this.mainContent = mainContent;
    }

    @Builder
    public MagazineDetailDto(Magazine saved, List<ContentImgJsonDto> contentImgJsonDto) {
        Random random = new Random();
        this.id = saved.getId();
        this.title = saved.getTitle();
        this.subTitle = saved.getSubTitle();
        this.author = saved.getAuthor();
        this.thumbnail = saved.getThumbnail();
        this.likes = random.nextInt(4000)+5000;
        this.viewCount = random.nextInt(10000)+20000;
        this.mainContent = contentImgJsonDto;
    }
}
