package org.vann.FourWheelerInsurance.filter;

public class jwtTokenMissingException extends RuntimeException{
	public jwtTokenMissingException(String message) {
		super(message);
	}

}