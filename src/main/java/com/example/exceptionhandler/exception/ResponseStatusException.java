package com.example.exceptionhandler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "ResponseStatusTest")
public class ResponseStatusException extends RuntimeException {
    public ResponseStatusException() {
    }
}
