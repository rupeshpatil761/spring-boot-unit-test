package com.rupesh.springboot.unittest.exception;

import com.rupesh.springboot.unittest.bean.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(Exception ex, WebRequest request) {
        GenericResponse exceptionResponse =
                new GenericResponse(ex.getMessage(),HttpStatus.NOT_FOUND.value());
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ Exception.class})
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        GenericResponse exceptionResponse =
                new GenericResponse(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
