package com.project.mybible.golbal.error.exception;

import lombok.Getter;

@Getter
public class MyBibleException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String message;

    public MyBibleException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }

    public MyBibleException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

}
