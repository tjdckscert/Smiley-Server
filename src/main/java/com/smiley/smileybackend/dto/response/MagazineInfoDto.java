package com.smiley.smileybackend.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class MagazineInfoDto {
    Integer id;
    String title;
    String subTitle;
    String author;
    String thumbnail;
    Integer likes;
    Integer viewCount;
    String contentLink;
    public MagazineInfoDto(Integer id, String title, String subTitle, String author, String thumbnail, Integer likes, Integer viewCount, String contentLink) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.thumbnail = thumbnail;
        this.likes = likes;
        this.viewCount = viewCount;
        this.contentLink = contentLink;
    }
}
