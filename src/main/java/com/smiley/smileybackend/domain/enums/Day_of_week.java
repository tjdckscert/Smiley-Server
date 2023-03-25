package com.smiley.smileybackend.domain.enums;

import lombok.Getter;

@Getter
public enum Day_of_week {

    MONDAY("MONDAY"),

    TUESDAY("WEEKLY"),

    WEDNESDAY(""),

    THURSDAY("MONTHLY"),

    FRIDAY("FRIDAY"),

    SATURDAY("SATURDAY"),

    SUNDAY("SUNDAY");

    private final String dayofweek;

    Day_of_week(String dayofweek) {
        this.dayofweek = dayofweek;
    }
}
