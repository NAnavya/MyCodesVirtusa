package com.virtusa.course.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.virtusa.course.entities.ErrorResponse;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse>  handledResourceNotFound(ResourceNotFoundException ex){
		ErrorResponse er=new ErrorResponse();
		er.setDate(LocalDate.now());
		er.setMessage(ex.getMessage());
		er.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.ok(er);
		
	}
	

}
