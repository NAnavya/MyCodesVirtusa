package org.vann.FourWheelerInsurance.exceptions;

public class PolicyNotFoundException extends RuntimeException {
	public PolicyNotFoundException(String desc) {
		super(desc);
	}
}