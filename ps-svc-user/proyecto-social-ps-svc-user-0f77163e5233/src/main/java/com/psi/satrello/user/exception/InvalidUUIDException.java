package com.psi.satrello.user.exception;

public class InvalidUUIDException extends RuntimeException{
    private final int status;

    public InvalidUUIDException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
