package com.virtusa.UrbanFashionSpringBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.UrbanFashionSpringBoot.model.CartItemsModel;
import com.virtusa.UrbanFashionSpringBoot.model.CartModel;
import com.virtusa.UrbanFashionSpringBoot.model.RegistrationModel;

public interface CartRepository extends JpaRepository<CartModel, Integer> {
	
	boolean existsByUser(RegistrationModel model);
	
	CartModel findByUser(RegistrationModel model);

}
