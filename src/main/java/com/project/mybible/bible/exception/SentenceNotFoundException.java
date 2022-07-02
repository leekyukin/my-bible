package com.project.mybible.bible.exception;

import com.project.mybible.golbal.error.exception.ErrorCode;
import com.project.mybible.golbal.error.exception.MyBibleException;

public class SentenceNotFoundException extends MyBibleException {

    public static final MyBibleException EXCEPTION = new SentenceNotFoundException();

    private SentenceNotFoundException() {super(ErrorCode.BAD_REQUEST, "존재하지 않는 구절입니다.");}
}
