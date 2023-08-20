package org.vann.FourWheelerInsurance.exceptions;

public class JWtTokenMalformedException extends RuntimeException {
	public JWtTokenMalformedException(String message) {
		super(message);
	}
}