package com.smiley.smileybackend.community.post.service;

import com.smiley.smileybackend.community.post.domain.Post;
import com.smiley.smileybackend.community.post.domain.enums.Category;
import com.smiley.smileybackend.community.post.dto.PostDto;
import com.smiley.smileybackend.community.post.repository.CommunityPostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    /**
     * 커뮤니티에서 특정 게시글을 수정하는 기능
     * @param id 게시글에 할당된 고유 인덱스
     * @param dto 수정할 게시글 객체
     * @return 
     */
    public Post update(Integer id, PostDto dto) {
        // 1. 변경할 내용의 게시물 entity 생성
        Post post = dto.toEntity();
        
        // 2. 변경할 대상 게시물 찾기
        Post target = repository.findById(id).orElse(null);

        // 3. 잘못된 요청 처리
        if(target == null || post.getUser().getId() == null) {
            log.info("잘못된 요청 id: {}, 게시물: {}", id, post.toString());
            return null;
        }

        // 4. 잘못된 요청이 없을 경우 게시물 업데이트
        target.patch(post);
        Post updated = repository.save(target);

        return updated;
    }

    public Post delete(Integer id) {
        // 1. 삭제할 대상 게시물 찾기
        Post target = repository.findById(id).orElse(null);

        // 2. 잘못된 요청 처리
        if (target == null)
            return null;

        // 3. DB에 저장된 게시물 삭제
        repository.delete(target);

        return target;
    }
}
