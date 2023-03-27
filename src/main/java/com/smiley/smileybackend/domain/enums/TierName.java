package com.smiley.smileybackend.domain.enums;

import lombok.Getter;

@Getter
public enum TierName {
    BRONZE("BRONZE"),
    SILVER("SILVER"),
    GOLD("GOLD"),
    PLATINUM("PLATINUM"),
    DIAMOND("DIAMOND"),
    RUBY("RUBY"),
    MASTER("MASTER");

    private final String tier;
    TierName(String tier) {
        this.tier = tier;
    }
}
