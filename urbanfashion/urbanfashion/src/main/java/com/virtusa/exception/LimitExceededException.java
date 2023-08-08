package com.virtusa.exception;

public class LimitExceededException extends RuntimeException {
	
	LimitExceededException(String msg){
		super(msg);
	}

}
