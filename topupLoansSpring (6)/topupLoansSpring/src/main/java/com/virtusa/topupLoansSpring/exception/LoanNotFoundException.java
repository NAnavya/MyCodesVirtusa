package com.virtusa.topupLoansSpring.exception;

public class LoanNotFoundException extends RuntimeException {
	 public LoanNotFoundException(String desc){
		super(desc);
	}

}
