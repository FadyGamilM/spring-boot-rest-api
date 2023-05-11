package com.socialmediarestapi.exceptions;

import com.socialmediarestapi.utils.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    // TODO : Generic method to handle all types of exceptions
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        var exceptionStructure = new ErrorDetails(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(exceptionStructure, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    // TODO : method to handle the not found resource exception
    public final ResponseEntity<ErrorDetails> handleNotFoundException(Exception ex, WebRequest request) throws Exception {
        var exceptionStructure = new ErrorDetails(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(exceptionStructure, HttpStatus.NOT_FOUND);
    }
}
