package com.smiley.smileybackend._01_user.repository;

import com.smiley.smileybackend._01_user.domain.UserMedicalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMedicalInfoRepository extends JpaRepository<UserMedicalInfo,Integer> {
}
