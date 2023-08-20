package com.virtusa.UrbanFashionSpringBoot.service;

import java.util.List;

import com.virtusa.UrbanFashionSpringBoot.model.CartItemsModel;
import com.virtusa.UrbanFashionSpringBoot.model.ProductModel;
import com.virtusa.UrbanFashionSpringBoot.model.RegistrationModel;

public interface userService {

	RegistrationModel editUser(String uemail,RegistrationModel model);

	RegistrationModel viewUser(String uemail);

	boolean deleteUser(String uemail);

	List<ProductModel> viewProducts();

	String addProductsToCart(String uemail, int pid, CartItemsModel cmodel);

}
 