package com.smiley.smileybackend.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
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

}
