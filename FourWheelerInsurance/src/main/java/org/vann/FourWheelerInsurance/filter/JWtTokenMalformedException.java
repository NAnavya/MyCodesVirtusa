package org.vann.FourWheelerInsurance.filter;

public class JWtTokenMalformedException extends RuntimeException{
	public JWtTokenMalformedException(String message) {
		super(message);
	}

}
