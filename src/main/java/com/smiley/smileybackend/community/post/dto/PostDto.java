package com.smiley.smileybackend.community.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smiley.smileybackend.community.post.domain.Post;
import com.smiley.smileybackend.community.post.domain.UserTest;
import com.smiley.smileybackend.community.post.domain.enums.Category;
import com.smiley.smileybackend.domain.User;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
public class PostDto {
    private Integer id;
    private String title;
    private String content;
    private Date createdPost;

    private User user;
    private Category category;

    public Post toEntity() {
        log.info("toEntity 들어옴");
        log.info("user.getId() = " + user.getId());
        log.info("후");
        return new Post(id, title, content, createdPost, user, category);
    }

}
