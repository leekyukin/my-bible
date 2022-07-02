package com.project.mybible.golbal.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "서버에 오류가 발생했습니다."),
    BAD_REQUEST(400, "잘못된 요청입니다."),

    USER_ALREADY_EXISTS(422, "사용지가 이미 존재합니다."),
    USER_NOT_FOUND(404, "존재하지 않는 사용자입니다."),
    MY_LIST_EMPTY(404, "마이 리스트가 비어있습니다.")
    ;

    private final int errorCode;
    private final String message;
}
