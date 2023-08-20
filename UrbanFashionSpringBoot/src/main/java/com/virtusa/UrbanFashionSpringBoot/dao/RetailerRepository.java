package com.virtusa.UrbanFashionSpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.UrbanFashionSpringBoot.model.RetailerModel;

public interface RetailerRepository extends JpaRepository<RetailerModel, Integer> {
	
	boolean existsByPcode(int pcode);
	
	RetailerModel findByPcode(int pcode);
	
	boolean existsByRid(int rid);
	
}
