package com.smiley.smileybackend.domain.enums;

import lombok.Getter;

@Getter
public enum ContentType {

    MAIN_CONTENT("MAIN_CONTENT"),

    SUMMARY("SUMMARY"),

    KEY("KEY");

    private final String type;

    ContentType(String type) {
        this.type = type;
    }
}
