package com.company.library.exception;

import org.springframework.http.HttpStatus;

public class NotFoundExceptionHandler extends RuntimeException {
    private HttpStatus status;
    private ErrorCode errorCode;
    private String errorMessage;

    public NotFoundExceptionHandler(HttpStatus status, ErrorCode errorCode){
        this.status = status;
        this.errorCode = errorCode;
    }
    public NotFoundExceptionHandler(HttpStatus status, String errorMessage ){
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
