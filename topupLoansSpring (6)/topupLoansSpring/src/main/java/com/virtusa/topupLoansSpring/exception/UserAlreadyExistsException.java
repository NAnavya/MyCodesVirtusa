package com.virtusa.topupLoansSpring.exception;

public class UserAlreadyExistsException extends RuntimeException {
		 public UserAlreadyExistsException(String desc){
			super(desc);
		}

}
