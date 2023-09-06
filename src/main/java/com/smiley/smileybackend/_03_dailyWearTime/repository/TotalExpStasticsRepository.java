package com.smiley.smileybackend._03_dailyWearTime.repository;

import com.smiley.smileybackend._01_user.domain.TotalExpStastics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalExpStasticsRepository extends JpaRepository<TotalExpStastics,Integer> {

}
