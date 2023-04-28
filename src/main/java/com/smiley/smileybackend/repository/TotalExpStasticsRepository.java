package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.TotalExpStastics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalExpStasticsRepository extends JpaRepository<TotalExpStastics,Integer> {

}
