package com.virtusa.service;

import java.util.Scanner;
import java.util.logging.Logger;

import com.virtusa.entity.ProductsEntity;
import com.virtusa.repository.ProductRepository;


public class ProductServiceImplementation implements ProductService {
	Scanner sc;
	Logger logger = Logger.getLogger(ProductServiceImplementation.class.getName());
	ProductRepository prorepo = new ProductRepository();
	ProductsEntity products = new ProductsEntity();

	@Override
	public void createProducts(ProductsEntity products,int userid) {
		prorepo.createProducts(products,userid);
		
	}

	@Override
	public void viewProducts() {
		if(prorepo.findProducts())
			logger.log(java.util.logging.Level.SEVERE, "{0}", prorepo.viewProducts());
		else
			logger.info("No Products Found");
	}

	@Override
	public void updateProducts() {
		viewProducts();
		logger.info("Enter product id to update");
		sc = new Scanner(System.in);
		int id = sc.nextInt();
		if(prorepo.findProductsId(id)) {
			prorepo.viewProductById(products,id);
			prorepo.updateProducts(id);
		}
		else {
			logger.info("product not found");
		}
		
	}

	@Override
	public void deleteProducts() {
		viewProducts();
		logger.info("Enter product id to delete");
		sc = new Scanner(System.in);
		int id = sc.nextInt();
		if(prorepo.findProductsId(id)){
			prorepo.viewProductById(products,id);
			prorepo.deleteProducts(id);
		}
		else
			logger.info("product not found");
	}

}
