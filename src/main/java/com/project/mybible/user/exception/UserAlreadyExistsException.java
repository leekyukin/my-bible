package com.project.mybible.user.exception;

import com.project.mybible.golbal.error.exception.ErrorCode;
import com.project.mybible.golbal.error.exception.MyBibleException;

public class UserAlreadyExistsException extends MyBibleException {

    public static final UserAlreadyExistsException EXCEPTION = new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS, ErrorCode.USER_ALREADY_EXISTS.getMessage());
    }
}
