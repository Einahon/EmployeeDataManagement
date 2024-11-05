package com.eliegloire.EmployeeDataManagement.error;

public class EmployeeBadRequestException extends Exception{
    public EmployeeBadRequestException() {
        super();
    }

    public EmployeeBadRequestException(String message) {
        super(message);
    }

    public EmployeeBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeBadRequestException(Throwable cause) {
        super(cause);
    }

    protected EmployeeBadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
