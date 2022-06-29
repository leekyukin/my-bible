package com.project.mybible.golbal.error;

import com.project.mybible.golbal.error.exception.ErrorCode;
import com.project.mybible.golbal.error.exception.MyBibleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class MyBibleExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(MyBibleException.class)
    public ErrorResponse handleMyBibleException(HttpServletRequest request, MyBibleException e) {
        log.error(
                "errorCode : {}, url : {}, message : {} ",
                e.getErrorCode(),
                request.getRequestURL(),
                e.getMessage()
        );
        return ErrorResponse.builder()
                .errorCode(e.getErrorCode().getErrorCode())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        log.error(
                "url : {}, message : {}",
                request.getRequestURI(),
                e.getMessage()
        );

        return ErrorResponse.builder()
                .errorCode(ErrorCode.INTERNAL_SERVER_ERROR.getErrorCode())
                .message(ErrorCode.INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }
}
