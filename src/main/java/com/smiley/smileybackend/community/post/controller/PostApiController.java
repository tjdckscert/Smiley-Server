package com.smiley.smileybackend.community.post.controller;

import com.smiley.smileybackend.community.post.domain.Post;
import com.smiley.smileybackend.community.post.domain.enums.Category;
import com.smiley.smileybackend.community.post.dto.PostDto;
import com.smiley.smileybackend.community.post.service.PostApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "PostApiController : 커뮤니티 게시글 관련 컨트롤러")
@Slf4j
@RestController
public class PostApiController {

    private final PostApiService postApiService;

    @GetMapping("/community/posts")
    @ApiOperation(value = "커뮤니티 게시판 전체 글 조회", notes = "커뮤니티 게시판에 등록된 전체 글 조회한다.")
    public List<Post> index() {
        return postApiService.index();
    }

    @GetMapping("/community/{category}/posts")
    @ApiOperation(value = "커뮤니티 카테고리 선택", notes = "커뮤니티 카테고리 선택에 따른 게시글을 조회한다.")
    public List<Post> categorySelectIndex(@PathVariable String category) {
        return postApiService.categorySelectIndex(category);
    }

    @GetMapping("/community/posts/{id}")
    @ApiOperation(value = "커뮤니티 특정 게시글 조회", notes = "커뮤니티 특정 게시글을 조회한다.")
    public Post show(@PathVariable Integer id) {
        return postApiService.show(id);
    }

    @PostMapping("/community/posts")
    @ApiOperation(value = "커뮤니티 글 작성", notes = "커뮤니티에 게시글을 작성한다.")
    public ResponseEntity<Post> create(@RequestBody PostDto dto) {
        log.info("dto.getUser() = {}", dto.getUser());
        Post created = postApiService.create(dto);

        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/community/posts/{id}")
    @ApiOperation(value = "커뮤니티 게시물 수정", notes = "커뮤니티 특정 게시물을 수정한다.")
    public ResponseEntity<Post> update(@PathVariable Integer id, @RequestBody PostDto dto) {
        Post updated = postApiService.update(id, dto);

        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/community/posts/{id}")
    @ApiOperation(value = "커뮤니티 게시물 삭제", notes = "커뮤니티에 게시물을 삭제한다.")
    public ResponseEntity<Post> delete(@PathVariable Integer id) {
        Post deleted = postApiService.delete(id);

        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).body(deleted) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    public PostApiController(PostApiService postApiService) {
        this.postApiService = postApiService;
    }
}
