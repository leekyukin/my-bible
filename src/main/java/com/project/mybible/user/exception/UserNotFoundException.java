package com.project.mybible.user.exception;

import com.project.mybible.golbal.error.exception.ErrorCode;
import com.project.mybible.golbal.error.exception.MyBibleException;

public class UserNotFoundException extends MyBibleException {

    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
