package com.smiley.smileybackend.community.post.domain;

import com.smiley.smileybackend.community.post.domain.enums.Category;
import com.smiley.smileybackend.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    @JoinColumn(name = "user")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    public void patch(Post updated) {
        if (updated.title != null)
            this.title = updated.getTitle();
        if (updated.content != null)
            this.content = updated.getContent();
    }

}
