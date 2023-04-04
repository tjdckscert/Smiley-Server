package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine,Integer> {

}
