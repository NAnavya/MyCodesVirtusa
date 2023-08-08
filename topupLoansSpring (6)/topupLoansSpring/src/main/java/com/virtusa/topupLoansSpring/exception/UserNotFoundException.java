package com.virtusa.topupLoansSpring.exception;

public class UserNotFoundException extends RuntimeException {
	 public UserNotFoundException(String desc){
		super(desc);
	}

}
