package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.DailyWearTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyWearTimeRepository extends JpaRepository<DailyWearTime,Integer> {
}
