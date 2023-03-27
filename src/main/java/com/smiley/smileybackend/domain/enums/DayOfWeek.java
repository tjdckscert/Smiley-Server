package com.smiley.smileybackend.domain.enums;

import lombok.Getter;

@Getter
public enum DayOfWeek {

    MONDAY("MONDAY"),

    TUESDAY("WEEKLY"),

    WEDNESDAY(""),

    THURSDAY("MONTHLY"),

    FRIDAY("FRIDAY"),

    SATURDAY("SATURDAY"),

    SUNDAY("SUNDAY");

    private final String dayofweek;

    DayOfWeek(String dayofweek) {
        this.dayofweek = dayofweek;
    }
}
