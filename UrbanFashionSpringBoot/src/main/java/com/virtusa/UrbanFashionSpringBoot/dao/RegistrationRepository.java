package com.virtusa.UrbanFashionSpringBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.UrbanFashionSpringBoot.model.RegistrationModel;

public interface RegistrationRepository extends JpaRepository<RegistrationModel, Integer> {
	
	boolean existsByUemail(String uemail);
	
	RegistrationModel findByUemail(String email);
	
	List<RegistrationModel> findByRole(String role);
	
	boolean existsByRole(String role);
}