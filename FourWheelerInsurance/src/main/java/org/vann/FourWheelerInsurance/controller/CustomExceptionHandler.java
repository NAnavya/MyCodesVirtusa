package org.vann.FourWheelerInsurance.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.vann.FourWheelerInsurance.exceptions.CartDataNotFoundException;
import org.vann.FourWheelerInsurance.exceptions.CustomerAllReadyExistException;
import org.vann.FourWheelerInsurance.exceptions.CustomerNotFoundException;

import org.vann.FourWheelerInsurance.exceptions.ProductNotFoundException;

import org.vann.FourWheelerInsurance.model.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler {

	final private static org.apache.log4j.Logger log = org.apache.log4j.LogManager
			.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(CustomerNotFoundException e) {
		ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value(),
				LocalDate.now());
		log.error(errorResponse);
		return ResponseEntity.ok(errorResponse);
	}

	@ExceptionHandler(CustomerAllReadyExistException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(CustomerAllReadyExistException e) {
		ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value(),
				LocalDate.now());
		log.error(errorResponse);
		return ResponseEntity.ok(errorResponse);
	}

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(BadCredentialsException e) {
		ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value(),
				LocalDate.now());
		log.error(errorResponse);
		return ResponseEntity.ok(errorResponse);
	}

	@ExceptionHandler(CartDataNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(CartDataNotFoundException e) {
		ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value(),
				LocalDate.now());
		log.error(errorResponse);
		return ResponseEntity.ok(errorResponse);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(ProductNotFoundException e) {
		ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value(),
				LocalDate.now());
		log.error(errorResponse);
		return ResponseEntity.ok(errorResponse);
	}

}