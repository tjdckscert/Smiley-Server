package com.smiley.smileybackend.domain.enums;


import lombok.Getter;

@Getter
public enum Repeat_period {
    DAILY("DAILY"),

    WEEKLY("WEEKLY"),

    MONTHLY("MONTHLY");
    private final String repeat;

    Repeat_period(String repeat) {
        this.repeat = repeat;
    }
}
