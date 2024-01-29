package com.psi.satrello.user.exception;

public class InvalidPersonalIdException extends RuntimeException{
    private final int status;

    public InvalidPersonalIdException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
