package com.smiley.smileybackend.repository;

import com.smiley.smileybackend.domain.UserMedicalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMedicalInfoRepository extends JpaRepository<UserMedicalInfo,Integer> {
}
