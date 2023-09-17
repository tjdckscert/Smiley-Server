package com.smiley.smileybackend._07_drug.repository;

import com.smiley.smileybackend._07_drug.domain.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<Drug,String> {

}
