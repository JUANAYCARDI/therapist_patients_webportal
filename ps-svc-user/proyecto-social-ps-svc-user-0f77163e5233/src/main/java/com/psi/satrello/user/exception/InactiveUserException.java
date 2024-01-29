package com.psi.satrello.user.exception;

public class InactiveUserException extends RuntimeException {
    private final int status;

    public InactiveUserException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
