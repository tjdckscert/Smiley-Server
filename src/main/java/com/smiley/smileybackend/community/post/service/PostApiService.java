package com.smiley.smileybackend.community.post.service;

import com.smiley.smileybackend.community.post.domain.Post;
import com.smiley.smileybackend.community.post.domain.enums.Category;
import com.smiley.smileybackend.community.post.dto.PostDto;
import com.smiley.smileybackend.community.post.repository.CommunityPostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PostApiService {

    private final CommunityPostRepository repository;

    // 댓글 관련 repository 생성하기

    public PostApiService(CommunityPostRepository repository) {
        this.repository = repository;
    }

    public List<Post> index() {

        return repository.findAll();
    }

    /**
     * 커뮤니티 게시글 카테고리를 선택했을 때 보여지는 데 필요한 데이터
     * @return 특정 카테고리에 해당하는 게시글 데이터
     */
    public List<Post> categorySelectIndex(String category) {
        System.out.println("테스트 중");
        return repository.findByCategory(category);
    }

    /**
     * 커뮤니티에서 특정 게시글을 선택했을 때 보여지는 데이터
     * @param id 게시글 아이디
     * @return 선택된 게시글 데이터
     */
    public Post show(Integer id) {
        return repository.findById(id).orElse(null);
    }


    public Post create(PostDto dto) {
        log.info("create 또 들어옴");
        Post post = dto.toEntity();

        System.out.println("post.getUser().getId() = " + post.getUser().getId());
        return (post.getUser().getId() != null) ?
                repository.save(post) :
                null;
    }

//    public Post update(Integer id, PostDto dto) {
//    }
//
//    public Post delete(Integer id) {
//    }
}
