package org.vann.FourWheelerInsurance.repositories;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vann.FourWheelerInsurance.entities.Customer;
import org.vann.FourWheelerInsurance.entities.Role;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Optional<Customer> findByUsername(String username);
	Customer findByEmailId(String emailId);
	}





