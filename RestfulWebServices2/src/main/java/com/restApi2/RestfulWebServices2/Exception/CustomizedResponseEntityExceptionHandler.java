package com.restApi2.RestfulWebServices2.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.restApi2.RestfulWebServices2.ContentNegotiation.UserNotFoundException;
import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(UserNotFoundException.class)
        public final ResponseEntity<Object> handleEmployeeNotFoundException(UserNotFoundException exception, WebRequest request) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
                request.getDescription(false));
            return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
        }

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                      HttpHeaders headers, HttpStatus status, WebRequest request) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
                    ex.getBindingResult().toString());
            return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
        }
}

