package com.psi.satrello.user.controller;

import com.psi.satrello.user.exception.*;
import com.psi.satrello.user.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/* This controller handles all therapist exceptions */
@RestControllerAdvice
public class TherapistControllerAdvice {
    @ExceptionHandler(value = InvalidTokenException.class)
    public ResponseEntity<ErrorDTO> invalidTokenHandler(InvalidTokenException ex) {
        // status code 401 UNAUTHORIZED
        int status = ex.getStatus();
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), status);
        return new ResponseEntity<>(errorDTO, HttpStatus.valueOf(status));
    }

    @ExceptionHandler(value = InvalidPersonalIdException.class)
    public ResponseEntity<ErrorDTO> invalidPersonalIdHandler(InvalidPersonalIdException ex) {
        // status code 400 BAD_REQUEST
        int status = ex.getStatus();
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), status);
        return new ResponseEntity<>(errorDTO, HttpStatus.valueOf(status));
    }

    @ExceptionHandler(value = InvalidUUIDException.class)
    public ResponseEntity<ErrorDTO> invalidUUIDHandler(InvalidUUIDException ex) {
        // status code 400 BAD_REQUEST
        int status = ex.getStatus();
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), ex.getStatus());
        return new ResponseEntity<>(errorDTO, HttpStatus.valueOf(status));
    }

    @ExceptionHandler(value = NotATherapistException.class)
    public ResponseEntity<ErrorDTO> notATherapistHandler(NotATherapistException ex) {
        // status code 400 BAD_REQUEST
        int status = ex.getStatus();
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), ex.getStatus());
        return new ResponseEntity<>(errorDTO, HttpStatus.valueOf(status));
    }

    @ExceptionHandler(value = UnauthorizedProfileException.class)
    public ResponseEntity<ErrorDTO> unauthorizedProfileHandler(UnauthorizedProfileException ex) {
        // status code 401 UNAUTHORIZED
        int status = ex.getStatus();
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), ex.getStatus());
        return new ResponseEntity<>(errorDTO, HttpStatus.valueOf(status));
    }

    @ExceptionHandler(value = InactiveUserException.class)
    public ResponseEntity<ErrorDTO> InactiveUserHandler(InactiveUserException ex) {
        // status code 401 UNAUTHORIZED
        int status = ex.getStatus();
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), ex.getStatus());
        return new ResponseEntity<>(errorDTO, HttpStatus.valueOf(status));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorDTO> unauthorizedProfileHandler(Exception ex) {
        // status code 500 Server error
        int status = 500;
        ErrorDTO errorDTO = new ErrorDTO("Internal server error: " + ex.getMessage(), status);
        return new ResponseEntity<>(errorDTO, HttpStatus.valueOf(status));
    }
}
