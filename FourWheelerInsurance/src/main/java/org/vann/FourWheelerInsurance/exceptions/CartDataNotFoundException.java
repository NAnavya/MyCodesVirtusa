package org.vann.FourWheelerInsurance.exceptions;

public class CartDataNotFoundException extends RuntimeException
{
public CartDataNotFoundException(String desc) {
super(desc);
}
}