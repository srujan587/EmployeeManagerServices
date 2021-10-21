package com.springboot.employee.employeemanager.exception;

public class EmployeeNotFoundException extends  RuntimeException{

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
