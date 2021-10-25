package com.example.exceptionhandler;

import com.example.exceptionhandler.exception.ControllerAdviceException;
import com.example.exceptionhandler.exception.ResponseStatusException;
import com.example.exceptionhandler.exception.ResponseStatusInAdviceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ControllerAdviceException.class)
    public ResponseEntity<ErrorResponse> handleControllerAdviceException() {
        return ResponseEntity.badRequest().body(new ErrorResponse("Handle ControllerAdviceException"));
    }

    @ExceptionHandler(ResponseStatusInAdviceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleResponseStatusInAdviceException() {
        return ResponseEntity.notFound().build();
    }

    //TODO: 탐구과제 6번
//    @ExceptionHandler(ResponseStatusException.class)
//    public ResponseEntity<ErrorResponse> handleResponseStatusException() {
//        return ResponseEntity.badRequest().body(new ErrorResponse("Handle ResponseStatusException"));
//    }
}
