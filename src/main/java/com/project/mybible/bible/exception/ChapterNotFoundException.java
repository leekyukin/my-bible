package com.project.mybible.bible.exception;

import com.project.mybible.golbal.error.exception.ErrorCode;
import com.project.mybible.golbal.error.exception.MyBibleException;

public class ChapterNotFoundException extends MyBibleException {

    public final static MyBibleException EXCEPTION = new ChapterNotFoundException();

    private ChapterNotFoundException() {
        super(ErrorCode.BAD_REQUEST, "존재하지 않는 장입니다.");
    }
}
