package com.psi.satrello.user.exception;

public class UnauthorizedProfileException extends RuntimeException{
    private final int status;

    public UnauthorizedProfileException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
