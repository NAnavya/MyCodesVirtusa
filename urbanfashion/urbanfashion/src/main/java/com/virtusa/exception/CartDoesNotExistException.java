package com.virtusa.exception;

public class CartDoesNotExistException extends RuntimeException {
	
	public CartDoesNotExistException(String msg){
		super(msg);
	}
}
