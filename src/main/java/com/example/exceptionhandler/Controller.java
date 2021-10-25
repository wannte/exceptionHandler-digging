package com.example.exceptionhandler;

import com.example.exceptionhandler.exception.ControllerAdviceException;
import com.example.exceptionhandler.exception.ControllerException;
import com.example.exceptionhandler.exception.ResponseStatusException;
import com.example.exceptionhandler.exception.ResponseStatusInAdviceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String helloWord() {
        return "helloWord";
    }

    @GetMapping("controller")
    public void controller() {
        throw new ControllerException();
    }

    @GetMapping("controllerAdvice")
    public void controllerAdvice() {
        throw new ControllerAdviceException();
    }

    @GetMapping("responseStatus")
    public void responseStatus() {
        throw new ResponseStatusException();
    }

    @GetMapping("responseStatusInAdvice")
    public void responseStatusInAdvice() {
        throw new ResponseStatusInAdviceException();
    }

    @ExceptionHandler(ControllerException.class)
    public ResponseEntity<Void> controllerHandler() {
        return ResponseEntity.badRequest().build();
    }
}
