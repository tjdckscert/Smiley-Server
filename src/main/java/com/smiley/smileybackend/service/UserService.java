package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.dto.response.UserInfo;
import com.smiley.smileybackend.dto.user.UserLogin;
import com.smiley.smileybackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserInfo login(@Valid UserLogin userLogin) {
        User user = userRepository.findByEmail(userLogin.getEmail()).orElse(
                null
        );
        if (user==null){
            user = userRepository.save(userLogin.toEntity());
        }
        return new UserInfo(user);
    }
}
