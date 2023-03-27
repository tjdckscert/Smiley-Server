package com.smiley.smileybackend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class Magazine {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String title;

    @Column(length = 200)
    private String subTitle;

    @Column(length = 20)
    private String author;

    @Column(length = 200)
    private String thumbnail;

    @Column
    private Integer likes;

    @Column
    private Integer viewCount;

    @Column(length = 500)
    private String contentLink;

    @Builder
    public Magazine(Integer id, String title, String subTitle, String author, String thumbnail, Integer likes, Integer viewCount, String contentLink) {
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
