package com.smiley.smileybackend._10_community.post.dto;

import com.smiley.smileybackend._10_community.post.domain.Post;
import com.smiley.smileybackend._10_community.post.domain.enums.Category;
import com.smiley.smileybackend._01_user.domain.User;
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
        log.info("toEntity user = {}", user);
        log.info("toEntity user.getUserNumber() = {}", user.getUserNumber());
        return new Post(id, title, content, createdPost, user, category);
    }

}
