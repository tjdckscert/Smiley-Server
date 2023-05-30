package com.smiley.smileybackend.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class SystemExceptionHandler {

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<ErrorMessageResponse> handler(ErrorException ex) {
        return ErrorMessageResponse.toResponseEntity(ex.getErrorCode());
    }
}
