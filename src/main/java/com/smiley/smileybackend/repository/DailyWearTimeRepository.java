package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.DailyWearTime;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface DailyWearTimeRepository extends JpaRepository<DailyWearTime,Integer> {
    List<DailyWearTime> findByUserIdOrderByIdDesc(Integer id, Pageable pageable);
}
