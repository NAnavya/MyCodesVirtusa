package org.vann.FourWheelerInsurance.exceptions;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String desc) {
		super(desc);
	}
}