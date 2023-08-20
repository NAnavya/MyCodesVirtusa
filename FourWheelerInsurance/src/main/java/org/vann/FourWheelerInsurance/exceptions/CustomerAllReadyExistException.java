package org.vann.FourWheelerInsurance.exceptions;

public class CustomerAllReadyExistException extends RuntimeException
{
public CustomerAllReadyExistException(String desc) {
super(desc);
}
}