package com.smiley.smileybackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DefaultMessageResponse {

    private String message;

    public static DefaultMessageResponse of(String message) {
        return new DefaultMessageResponse(message);
    }
}
