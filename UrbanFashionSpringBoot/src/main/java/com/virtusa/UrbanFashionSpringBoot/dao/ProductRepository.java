package com.virtusa.UrbanFashionSpringBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtusa.UrbanFashionSpringBoot.model.ProductModel;
import com.virtusa.UrbanFashionSpringBoot.model.RetailerModel;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
	
	boolean existsByPcode(RetailerModel code);
	
	ProductModel findByPcode(RetailerModel code);
	
	ProductModel findByPid(int pid);
	
	boolean existsByPid(int pid);
	
	
}
