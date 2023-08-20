package org.vann.FourWheelerInsurance.filter;

public class CartDataNotFoundException extends RuntimeException{
	public CartDataNotFoundException(String desc) {
		super(desc);
	}

}
