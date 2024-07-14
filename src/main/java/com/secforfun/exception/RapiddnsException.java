package com.secforfun.exception;

public class RapiddnsException extends RuntimeException {
    public RapiddnsException(String message) {
        super(message);
    }

    public RapiddnsException(String message, Throwable cause) {
        super(message, cause);
    }
}
