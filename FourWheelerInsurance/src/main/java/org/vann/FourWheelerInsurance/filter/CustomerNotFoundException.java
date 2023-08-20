package org.vann.FourWheelerInsurance.filter;

public class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException(String desc) {
		super(desc);
	}

}
