package org.virtusa.custmerapiprac1.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.virtusa.custmerapiprac1.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    //These are the query generation methods here we no need to write any queries  just see the javaguides
	Optional<Customer> findByCustomerName(String customerName);
	Optional<Customer> findByCustomerNameAndCustomerAddress(String customerName,String customerAddress);
	Customer findByCustomerNameOrCustomerAddress(String customerName,String customerAddress);
	List<Customer> findByDateOfBirthAfter(String dateOfBirth);
	
}




