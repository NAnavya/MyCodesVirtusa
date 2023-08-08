package com.virtusa.service;

public interface UserService {

	void viewProfile(String email);

	void updateProfile(String str1);

	void viewProducts();

	void addProductsToCart(String str1);

	void viewCart(String str1);

	void bookProducts(String str1);

	void getMetaData();

	void updateCart(String str1);

	void deleteCart(String str1);

	void deleteProfile(String str1);
	
	void viewProductsBySize();
}
