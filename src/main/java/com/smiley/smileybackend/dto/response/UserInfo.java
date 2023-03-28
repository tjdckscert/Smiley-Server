package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Data
@Slf4j
@NoArgsConstructor
public class UserInfo {
    private Integer id;

    private String email;

    private String phoneToken;

    private String name;

    private LocalDate bitrhdate;

    public UserInfo(User saved) {
        this.id = saved.getId();
        this.email = saved.getEmail();
        this.phoneToken = saved.getPhoneToken();
        this.name = saved.getName();
        this.bitrhdate = saved.getBirthDate();
    }
}
