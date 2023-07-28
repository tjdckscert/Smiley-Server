package com.smiley.smileybackend.community.post.domain;

import com.smiley.smileybackend.community.post.domain.enums.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
@Getter @Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdPost;

    @Column(name = "user_id")
    private int userId;

    @Enumerated(EnumType.STRING)
    private Category category;

}
