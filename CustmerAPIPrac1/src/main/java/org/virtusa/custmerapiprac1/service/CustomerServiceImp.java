package org.virtusa.custmerapiprac1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.custmerapiprac1.entities.Customer;
import org.virtusa.custmerapiprac1.exceptions.CustomerNotFoundException;
import org.virtusa.custmerapiprac1.repo.CustomerRepository;

@Service
@Transactional // when we use transactional management the data should be commited automatically
public class CustomerServiceImp implements CustomerService {
    @Autowired
	private CustomerRepository customerRepository;
	@Override
	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
		
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public void deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(cid);
		
	}

	@Override
	public Customer getCustomer(int cid) {
		// TODO Auto-generated method stub
		return customerRepository.findById(cid).orElseThrow(()-> new CustomerNotFoundException("Customer Not Found"));
	}

	@Override
	public void updateCustomer(int cid, Customer customer) {
		// TODO Auto-generated method stub
		Customer customer2=customerRepository.findById(cid).orElseThrow(()->new CustomerNotFoundException("Customer Not Found"));
		customer2.setCustomerName(customer.getCustomerName());
		customer2.setCustomerAddress(customer.getCustomerAddress());
		customer2.setDateOfBirth(customer.getDateOfBirth());
		customerRepository.save(customer2);
	}

}
