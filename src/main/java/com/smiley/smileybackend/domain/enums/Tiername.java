package com.smiley.smileybackend.domain.enums;

import lombok.Getter;

@Getter
public enum Tiername {
    BRONZE("BRONZE"),
    SILVER("SILVER"),
    GOLD("GOLD"),
    PLATINUM("PLATINUM"),
    DIAMOND("DIAMOND"),
    RUBY("RUBY"),
    MASTER("MASTER");

    private final String tier;
    Tiername(String tier) {
        this.tier = tier;
    }
}
