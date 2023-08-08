package org.virtusa.custmerapiprac1.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.virtusa.custmerapiprac1.entities.ErrorResponse;
import org.virtusa.custmerapiprac1.exceptions.CustomerNotFoundException;

//when ever exception is raised then we have give these response to the client
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(CustomerNotFoundException cne){
		ErrorResponse errorResponse =new ErrorResponse();
		errorResponse.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorResponse.setErrorMessage(cne.getMessage());
		errorResponse.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception e){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorResponse.setErrorMessage(e.getMessage());
		errorResponse.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.OK);
	}

}
