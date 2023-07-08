package com.company.library.exception;

import org.springframework.http.HttpStatus;

public class NotFoundExceptionHandler extends RuntimeException {
    private HttpStatus status;
    private ErrorCode errorCode;

    public HttpStatus getStatus() {
        return status;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
