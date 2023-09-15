package com.smiley.smileybackend._00_common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.concurrent.locks.Lock;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum ErrorCode {
    NEW_USER(NOT_EXTENDED, "등록되어 있지 않은 회원입니다."),
    MAGAZINE_NOT_FOUND(LOCKED, "메거진 정보를 찾을 수 없습니다"),
    DEVICE_ALREADY_REGISTER(BAD_REQUEST, "디바이스가 이미 등록되어 있습니다."),
    PICTURE_NOT_FOUND(INTERNAL_SERVER_ERROR, "사진을 찾을 수 없습니다"),
    HOSPITAL_NOT_FOUND(LOCKED, "병원 정보를 찾을 수 없습니다"),
    USER_NOT_FOUND(LOCKED, "사용자를 찾을 수 없습니다"),
    BOOKING_NOT_FOUND(LOCKED, "예약정보를 찾을 수 없습니다."),
    BOOKING_INFORMATION_NOT_MATCH(FORBIDDEN, "예약정보의 번호와 사용자의 번호가 일치하지 않습니다."),
    MEDICINE_NOT_FOUND(LOCKED, "약품 정보를 찾을 수 없습니다");
    private final HttpStatus httpStatus;
    private final String detail;

    ErrorCode(HttpStatus httpStatus, String detail) {
        this.httpStatus = httpStatus;
        this.detail = detail;
    }
}

