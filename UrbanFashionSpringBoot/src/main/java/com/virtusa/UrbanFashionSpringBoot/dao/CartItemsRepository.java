package com.virtusa.UrbanFashionSpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.UrbanFashionSpringBoot.model.CartItemsModel;
import com.virtusa.UrbanFashionSpringBoot.model.ProductModel;

public interface CartItemsRepository extends JpaRepository<CartItemsModel, Integer> {
	
	
	boolean existsByPid(ProductModel pid);
	
	CartItemsModel findByPid(ProductModel pid);
	
}
