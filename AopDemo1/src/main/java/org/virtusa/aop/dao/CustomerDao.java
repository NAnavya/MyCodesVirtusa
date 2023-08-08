package org.virtusa.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class CustomerDao {
	public void insertCustomer() {
		System.out.println(getClass()+" Insert customer");
	}
	public void something() {
		System.out.println(getClass()+" do something");
	}
}
