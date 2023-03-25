package com.smiley.smileybackend.domain.enums;

import lombok.Getter;

@Getter
public enum Tier {
    BRONZE("BRONZE"),
    SILVER("SILVER"),
    GOLD("GOLD"),
    PLATINUM("PLATINUM"),
    DIAMOND("DIAMOND"),
    RUBY("RUBY"),
    MASTER("MASTER");

    private final String tier;
    Tier(String tier) {
        this.tier = tier;
    }
}
