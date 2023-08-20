package org.vann.FourWheelerInsurance.exceptions;

public class jwtTokenMissingException extends RuntimeException {
	public jwtTokenMissingException(String message) {
		super(message);
	}
}
