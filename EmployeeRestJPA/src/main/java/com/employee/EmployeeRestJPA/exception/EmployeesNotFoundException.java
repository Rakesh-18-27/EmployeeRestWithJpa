package com.employee.EmployeeRestJPA.exception;

public class EmployeesNotFoundException extends RuntimeException{
    public EmployeesNotFoundException(String message){
        super(message);
    }
}
