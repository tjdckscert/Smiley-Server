package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.Magazine;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine,Integer> {

    List<Magazine> findAllByOrderByIdDesc(Pageable pageable);

}
