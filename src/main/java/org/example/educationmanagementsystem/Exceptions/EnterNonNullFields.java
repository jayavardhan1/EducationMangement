package org.example.educationmanagementsystem.Exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class EnterNonNullFields extends RuntimeException{
    public EnterNonNullFields(String message) {
        super(message);
    }
}
