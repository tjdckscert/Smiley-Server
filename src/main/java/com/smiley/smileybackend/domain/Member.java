package com.smiley.smileybackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;




@NoArgsConstructor
@Getter
public class Member {

    private String name;
    private int age;

    public Member(String name, int age){
        this.name=name;
        this.age=age;
    }


}