package com.smiley.smileybackend._01_user.repository;

import com.smiley.smileybackend._01_user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUserNumber(String userNumber);
}
