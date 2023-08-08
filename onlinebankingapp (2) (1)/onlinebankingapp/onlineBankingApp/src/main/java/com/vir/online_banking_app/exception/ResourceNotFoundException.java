package com.vir.online_banking_app.exception;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String desc) {
		super(desc);
	}

}
