package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.DailyExpStastics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DailyExpStasticsRepository extends JpaRepository<DailyExpStastics,Integer> {

    Optional<DailyExpStastics> findByUser_IdAndDate(Integer user_id, LocalDate date);
}
