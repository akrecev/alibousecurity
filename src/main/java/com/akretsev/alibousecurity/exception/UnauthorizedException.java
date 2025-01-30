package com.akretsev.alibousecurity.exception;

public class UnauthorizedException extends ApiException {
    public UnauthorizedException(String message) {
        super(message, "UNAUTHORISED");
    }
}
