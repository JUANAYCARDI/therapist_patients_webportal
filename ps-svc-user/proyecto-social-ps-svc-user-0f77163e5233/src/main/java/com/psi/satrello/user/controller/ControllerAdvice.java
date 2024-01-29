package com.psi.satrello.user.controller;

import com.psi.satrello.user.model.ErrorDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    // General method used to create a new error response
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> RuntimeExceptionHandler(RuntimeException ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage(), 400);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
