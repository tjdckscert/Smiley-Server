package com.smiley.smileybackend.community.post.domain;

import com.smiley.smileybackend.community.post.domain.enums.Category;
import com.smiley.smileybackend.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column
    private String content;


    @Column(name = "created_post", nullable = false, updatable = false)
    private Date createdPost;

    @ManyToOne
    @JoinColumn(name = "users") // 이름 변경하기
    private UserTest user;

//    @Enumerated(EnumType.STRING) // 하는 법 찾아보기
    @Column(nullable = false)
    private String category;

}
