package com.calculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculator.model.CustomerModel;
import com.calculator.repository.CustomerRepository;
import com.calculator.dto.CustomerDto;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public CustomerModel findbyIdandEmail(int customerId, String customerEmail) {
		return customerRepository.findByCustomerIdAndCustomerEmail(customerId, customerEmail);

	}

	public void saveCustomer(CustomerDto customer) {
		CustomerModel customerModel = new CustomerModel(customer.getCustomerName(),customer.getCustomerMobile(),customer.getCustomerEmail(),customer.getCustomerPassword(),customer.getRole());
		customerRepository.save(customerModel);
	}

	public List<CustomerModel> viewCustomers() {
		return customerRepository.findAll();
	}

	public CustomerModel findbyEmailandPassword(String customerEmail, String customerPassword) {
		return customerRepository.findByCustomerEmailAndCustomerPassword(customerEmail, customerPassword);
	}

	public CustomerModel findbyemail(String customerEmail) {
		return customerRepository.findByCustomerEmail(customerEmail);
	}

}
