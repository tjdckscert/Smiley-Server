package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Magazine;
import lombok.*;

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

    @Builder
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

    public static MagazineInfoDto entityToDto(Magazine magazine){
        return new MagazineInfoDto(
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
