package com.employee.EmployeeRestJPA.controller;

import com.employee.EmployeeRestJPA.exception.EmployeeNotFoundException;
import com.employee.EmployeeRestJPA.exception.EmployeesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }


    @ExceptionHandler(EmployeesNotFoundException.class)
    public ResponseEntity<String> handleEmployeesNotFoundException(EmployeesNotFoundException employeesNotFoundException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(employeesNotFoundException.getMessage());
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeesNotFoundException(EmployeeNotFoundException employeeNotFoundException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(employeeNotFoundException.getMessage());
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<String> handleHttpMessageNotWritableException(HttpMessageNotWritableException employeeNotFoundException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(employeeNotFoundException.getMessage());
    }
}
