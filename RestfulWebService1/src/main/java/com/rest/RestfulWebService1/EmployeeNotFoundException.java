package com.rest.RestfulWebService1;

public class EmployeeNotFoundException extends Throwable {
    public EmployeeNotFoundException(String message) {
            super(message);
    }
}
