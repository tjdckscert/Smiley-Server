package com.smiley.smileybackend.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum ErrorCode {
    NEW_USER(NOT_EXTENDED, "등록되어 있지 않은 회원입니다."),
    MAGAZINE_NOT_FOUND(NOT_FOUND, "메거진 정보를 찾을 수 없습니다"),
    DEVICE_ALREADY_REGISTER(NOT_FOUND, "디바이스가 이미 등록되어 있습니다."),
    PICTURE_NOT_FOUND(NOT_FOUND, " 사진을 찾을 수 없습니다"),
    HOSPITAL_NOT_FOUND(NOT_FOUND, "병원 정보를 찾을 수 없습니다"),
    USER_NOT_FOUND(NOT_FOUND, "사용자를 찾을 수 없습니다"),
    BOOKING_NOT_FOUND(NOT_FOUND, "예약정보를 찾을 수 없습니다."),
    BOOKING_INFORMATION_NOT_MATCH(NOT_FOUND, "예약정보가 일치하지 않습니다."),
    MEDICINE_NOT_FOUND(NOT_FOUND, "약품 정보를 찾을 수 없습니다");
    private final HttpStatus httpStatus;
    private final String detail;

    ErrorCode(HttpStatus httpStatus, String detail) {
        this.httpStatus = httpStatus;
        this.detail = detail;
    }
}

