package com.visa.events.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * custom exception handler to customize error response.
 *
 * @author ThirupathiReddy
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     * Returns simplified error messages
     *
     * @param ex      exception
     * @param headers headers
     * @param status  status
     * @param request request
     * @return list of errors
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
            headers, HttpStatus status, WebRequest request) {

        List errors = ex.getBindingResult()
                .getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());

        return handleExceptionInternal(ex, errors, headers, status, request);
    }


}
