package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Magazine;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.core.io.Resource;

@Getter
@ToString
@NoArgsConstructor
public class MagazineDetailDto {

    @ApiModelProperty( example = "인덱스/Integer")
    Integer id;
    @ApiModelProperty( example = "이미지")
    Resource resource;
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
    @ApiModelProperty( example = "연결주소")
    String contentLink;

    @Builder
    public MagazineDetailDto(Integer id, Resource resource, String title, String subTitle, String author, String thumbnail, Integer likes, Integer viewCount, String contentLink) {
        this.id = id;
        this.resource = resource;
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.thumbnail = thumbnail;
        this.likes = likes;
        this.viewCount = viewCount;
        this.contentLink = contentLink;
    }

    @Builder
    public MagazineDetailDto(Integer id, String title, String subTitle, String author, String thumbnail, Integer likes, Integer viewCount, String contentLink) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.thumbnail = thumbnail;
        this.likes = likes;
        this.viewCount = viewCount;
        this.contentLink = contentLink;
    }

    @Builder
    public MagazineDetailDto(Magazine saved, Resource resource) {
        this.id = saved.getId();
        this.resource = resource;
        this.title = saved.getTitle();
        this.subTitle = saved.getSubTitle();
        this.author = saved.getAuthor();
        this.thumbnail = saved.getThumbnail();
        this.likes = saved.getLikes();
        this.viewCount = saved.getViewCount();
        this.contentLink = saved.getContentLink();
    }

    @Builder
    public static MagazineDetailDto entityToDto(Magazine magazine){
        return new MagazineDetailDto(
                magazine.getId(),
                magazine.getTitle(),
                magazine.getSubTitle(),
                magazine.getAuthor(),
                magazine.getThumbnail(),
                magazine.getLikes(),
                magazine.getViewCount(),
                magazine.getContentLink());
    }
}
