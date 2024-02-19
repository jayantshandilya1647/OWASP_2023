package com.example.EmployeeService.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

//@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public String handleException(){
       return "User is not authorized";
    }
}
