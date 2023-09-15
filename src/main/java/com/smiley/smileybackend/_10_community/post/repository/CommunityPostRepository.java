package com.smiley.smileybackend._10_community.post.repository;

import com.smiley.smileybackend._10_community.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommunityPostRepository extends JpaRepository<Post, Integer> {

    @Override
    ArrayList<Post> findAll();

    // 특정 카테고리에 해당하는 게시글 조회
    @Query(value = "SELECT * FROM post WHERE category = :selectCategory", nativeQuery = true)
    List<Post> findByCategory(@Param("selectCategory")String category);
}
