package com.virtusa.service;

import com.virtusa.entity.ProductsEntity;

public interface ProductService {

	void createProducts(ProductsEntity products, int userid);

	void viewProducts();

	void updateProducts();

	void deleteProducts();

}
