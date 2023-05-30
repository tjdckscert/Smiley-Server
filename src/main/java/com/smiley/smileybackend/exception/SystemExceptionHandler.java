package com.smiley.smileybackend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class SystemExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<DefaultMessageResponse> handle(IllegalArgumentException ex, WebRequest request) {

        DefaultMessageResponse response = DefaultMessageResponse.of(ex.getMessage());

        return ResponseEntity.badRequest().body(response);
    }
}
