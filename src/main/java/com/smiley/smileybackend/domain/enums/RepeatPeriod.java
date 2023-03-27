package com.smiley.smileybackend.domain.enums;


import lombok.Getter;

@Getter
public enum RepeatPeriod {
    DAILY("DAILY"),

    WEEKLY("WEEKLY"),

    MONTHLY("MONTHLY");
    private final String repeat;

    RepeatPeriod(String repeat) {
        this.repeat = repeat;
    }
}
