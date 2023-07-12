package com.example.demo.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity ProductNotFoundException(ChangeSetPersister.NotFoundException ex){
        return ResponseEntity.notFound().build();
    }
}
