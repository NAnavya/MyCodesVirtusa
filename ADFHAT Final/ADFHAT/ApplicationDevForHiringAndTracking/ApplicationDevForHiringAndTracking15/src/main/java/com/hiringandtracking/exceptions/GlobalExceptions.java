package com.hiringandtracking.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptions {




    /*
    @Exception handling for the invalid Arguments
    @Used for the validation of arguments
    @MethodArgumentNotValidException is handled
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidargument(MethodArgumentNotValidException ex) {


        Map<String,String> errorMap= new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        errorMap.put(error.getField(), error.getDefaultMessage())
            );

        return errorMap;
    }


    /*
    @Exception handling for no Records
    @Used for the checking records
    @RecordNotFoundException is handled
     */
   @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RecordNotFoundException.class)
    public ErrorMessage recordNotFoundException(RecordNotFoundException ex, WebRequest request){
        return new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
    }


}


