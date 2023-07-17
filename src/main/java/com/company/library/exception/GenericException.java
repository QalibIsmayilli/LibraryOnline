package com.company.library.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException {
    private HttpStatus status;
    private ErrorCode errorCode;
    private String errorMessage;

    public GenericException(HttpStatus status, ErrorCode errorCode){
        this.status = status;
        this.errorCode = errorCode;
    }
    public GenericException(HttpStatus status, String errorMessage ){
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
