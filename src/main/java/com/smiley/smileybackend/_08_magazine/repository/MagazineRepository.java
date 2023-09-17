package com.smiley.smileybackend._08_magazine.repository;

import com.smiley.smileybackend._08_magazine.domain.Magazine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MagazineRepository extends JpaRepository<Magazine,Integer> {

    Page<Magazine> findAllByOrderByIdDesc(Pageable pageable);

    Magazine findTopByOrderByIdDesc();


}
