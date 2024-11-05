package com.eliegloire.EmployeeDataManagement.error;

import com.eliegloire.EmployeeDataManagement.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorMessage> employeeNotFoundException(EmployeeNotFoundException exception, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

    }
//    @ExceptionHandler(EmployeeBadRequestException.class)
//public ResponseEntity<ErrorMessage> employeeBadRequestException(EmployeeBadRequestException exception, WebRequest request){
//        ErrorMessage messag = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messag);
//}

    @ExceptionHandler(EmployeeBadRequestException.class)
    public ResponseEntity<ErrorMessage> handleValidationExceptions(EmployeeBadRequestException exception) {
        ErrorMessage errors = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }
    }
