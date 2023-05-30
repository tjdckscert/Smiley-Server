package com.smiley.smileybackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
public enum ErrorCode {
    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    MAGAZINE_NOT_FOUND(NOT_FOUND, "메거진 정보를 찾을 수 없습니다"),
    PICTURE_NOT_FOUND(NOT_FOUND, " 사진을 찾을 수 없습니다"),
    HOSPITAL_NOT_FOUND(NOT_FOUND, "병원 정보를 찾을 수 없습니다"),
    USER_NOT_FOUND(NOT_FOUND, "사용자를 찾을 수 없습니다"),
    MEDICINE_NOT_FOUND(NOT_FOUND, "약품 정보를 찾을 수 없습니다");

    private final HttpStatus httpStatus;
    private final String detail;

    ErrorCode(HttpStatus httpStatus, String detail) {
        this.httpStatus = httpStatus;
        this.detail = detail;
    }
}

