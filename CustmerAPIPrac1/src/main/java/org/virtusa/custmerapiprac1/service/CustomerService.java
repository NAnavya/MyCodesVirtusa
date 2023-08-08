package org.virtusa.custmerapiprac1.service;

import java.util.List;

import org.virtusa.custmerapiprac1.entities.Customer;

public interface CustomerService {
	void insertCustomer(Customer customer);
	List<Customer> getCustomers();
	void deleteCustomer(int cid);
	Customer getCustomer(int cid);
	void updateCustomer(int cid,Customer customer);
	
	

}
