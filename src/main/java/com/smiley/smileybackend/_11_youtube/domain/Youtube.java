package com.smiley.smileybackend._11_youtube.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
public class Youtube implements Serializable{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String title;

    @Column(length = 200)
    private String thumbnail;

    @Column
    private String urlLink;

    @Builder
    public Youtube(Integer id, String title, String thumbnail, String urlLink) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.urlLink = urlLink;
    }
}
