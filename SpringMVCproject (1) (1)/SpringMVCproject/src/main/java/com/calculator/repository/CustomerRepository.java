package com.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.calculator.model.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {

	CustomerModel findByCustomerEmailAndCustomerPassword(String customerEmail, String customerPassword);

	CustomerModel findByCustomerId(int customerId);

	CustomerModel findByCustomerIdAndCustomerEmail(int customerId, String customerEmail);

	CustomerModel findByCustomerEmail(String customerEmail);

}
