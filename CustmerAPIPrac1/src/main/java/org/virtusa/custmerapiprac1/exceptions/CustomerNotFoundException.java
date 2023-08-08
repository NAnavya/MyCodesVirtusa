package org.virtusa.custmerapiprac1.exceptions;

public class CustomerNotFoundException extends RuntimeException {
     public CustomerNotFoundException(String desc){
    	 super(desc);
     }
}
