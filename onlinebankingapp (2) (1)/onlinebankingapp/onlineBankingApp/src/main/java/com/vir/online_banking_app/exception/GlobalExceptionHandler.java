package com.vir.online_banking_app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vir.online_banking_app.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> getResponse(Exception e){
		ErrorResponse er=new ErrorResponse();
		er.setErrorMessage(e.getMessage());
		er.setStatusCode(HttpStatus.BAD_REQUEST.value());
		er.setDate(LocalDateTime.now());
		return new ResponseEntity<>(er,HttpStatus.OK);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> getResponse(ResourceNotFoundException e){
		ErrorResponse er=new ErrorResponse();
		er.setErrorMessage(e.getMessage());
		er.setDate(LocalDateTime.now());
		er.setStatusCode(HttpStatus.NOT_FOUND.value());
	   return new ResponseEntity<>(er,HttpStatus.OK);
		
	}

}
