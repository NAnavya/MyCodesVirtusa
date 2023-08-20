package org.vann.FourWheelerInsurance.filter;

public class CustomerAllReadyExistException extends RuntimeException{
	public CustomerAllReadyExistException(String desc) {
		super(desc);
	}

}