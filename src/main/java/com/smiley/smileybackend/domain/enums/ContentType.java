package com.example.deuproject.controller;

import lombok.Getter;

@Getter
public enum ContentType {

    MAINCONTENT("MAINCONTENT"),

    SUMMARYCONTENT("SUMMARYCONTENT"),

    KEYCONTENT("KEYCONTENT");

    private final String type;

    ContentType(String type) {
        this.type = type;
    }
}
