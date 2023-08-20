package org.vann.FourWheelerInsurance.filter;

public class ProductNotFoundException extends RuntimeException{
	public ProductNotFoundException(String desc) {
		super(desc);
	}

}
