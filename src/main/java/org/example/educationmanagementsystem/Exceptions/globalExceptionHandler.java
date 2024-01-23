package org.example.educationmanagementsystem.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class globalExceptionHandler {
    @ExceptionHandler(value = classNotFoundException.class)
    public ResponseEntity<String> exception(classNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(value = EnterNonNullFields.class)
    public ResponseEntity<String> exception(EnterNonNullFields exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
