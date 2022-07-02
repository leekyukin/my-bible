package com.project.mybible.user.exception;

import com.project.mybible.golbal.error.exception.ErrorCode;
import com.project.mybible.golbal.error.exception.MyBibleException;

public class MyListEmptyException extends MyBibleException {

    public static final MyListEmptyException EXCEPTION = new MyListEmptyException();

    private MyListEmptyException() {
        super(ErrorCode.MY_LIST_EMPTY);
    }

}
