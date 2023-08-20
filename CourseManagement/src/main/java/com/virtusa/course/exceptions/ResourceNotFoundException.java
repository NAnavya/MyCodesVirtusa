package com.virtusa.course.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String desc){
		super(desc);
	}

}
