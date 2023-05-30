package com.smiley.smileybackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class SmileyErrorException extends RuntimeException{

    private final ErrorCode errorCode;
}
