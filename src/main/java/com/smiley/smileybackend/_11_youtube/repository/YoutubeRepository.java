package com.smiley.smileybackend._11_youtube.repository;

import com.smiley.smileybackend._11_youtube.domain.Youtube;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface YoutubeRepository extends JpaRepository<Youtube,Integer> {

    Page<Youtube> findAllByOrderByIdDesc(Pageable pageable);


    //@Query("select y from Youtube y order by rand() limit 2")
    //Page<Youtube> findAllByRandom(Pageable pageable);


}
