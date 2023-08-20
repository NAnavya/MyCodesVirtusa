package org.vann.FourWheelerInsurance.filter;

public class PolicyNotFoundException extends RuntimeException{
	public PolicyNotFoundException(String desc) {
		super(desc);
	}

}