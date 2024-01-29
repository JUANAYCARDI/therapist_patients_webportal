package com.psi.satrello.user.exception;

public class NotATherapistException extends RuntimeException{
    private final int status;

    public NotATherapistException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
