package com.psi.satrello.user.exception;

public class InvalidTokenException extends RuntimeException{
    private final int status;

    public InvalidTokenException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
