package com.virtusa.service;

import java.util.Scanner;
import java.util.logging.Logger;

import com.virtusa.entity.RegistrationEntity;
import com.virtusa.exception.ProductException;
import com.virtusa.repository.AdminRepository;
import com.virtusa.repository.CartRepository;
import com.virtusa.repository.ProductRepository;
import com.virtusa.repository.UserRepository;

public class UserServiceImplementation implements UserService {

	Logger logger = Logger.getLogger(UserServiceImplementation.class.getName());
	RegistrationEntity registration = new RegistrationEntity();
	ProductRepository prorepo = new ProductRepository();
	AdminRepository adrepo = new AdminRepository();
	UserRepository usrepo = new UserRepository();
	CartRepository carrepo = new CartRepository();
	Scanner sc;

	public void updateProfile(String str1) {
		if (adrepo.findUserByEmailId(str1))
			usrepo.updateUserByEmailIdFromUser(str1);
		else
			logger.info("Invalid");

	}

	public void viewProfile(String email) {
		if (adrepo.findUserByEmailId(email))
			adrepo.viewUserByEmailId(email);
		else
			logger.info("Users Not Found");
	}

	@Override
	public void viewProducts() {
		if (prorepo.findProducts()) {
			usrepo.viewProducts();
		} else
			logger.info("No Products Found");

	}

	@Override
	public void addProductsToCart(String str1) {
		try {
		viewProductsBySize();
		
			if (prorepo.findProducts()) {
				logger.info("Enter Product id");
				int pid = sc.nextInt();
				if (prorepo.findProductsId(pid)) {
					sc = new Scanner(System.in);
					logger.info("Enter Product quantity");
					int pq = sc.nextInt();
					if (pq > 0)
						carrepo.addToCart(pid, pq, str1);
					else
						throw new ProductException("ProductQunatity should be greater than Zero");
				}
			}
		} catch (ProductException pe) {
			logger.info(pe.getMessage());
		}

	}

	@Override
	public void viewCart(String str1) {
		if (carrepo.viewCart(str1)) {
			logger.info("Cart Found");
		} else
			logger.info("Cart is Empty!");
	}

	@Override
	public void bookProducts(String str1) {

		if (carrepo.bookProducts(str1)) {
			logger.info("Cart Found");
		} else
			logger.info("Cart is empty");

	}

	@Override
	public void getMetaData() {
		carrepo.getMetaData();

	}

	@Override
	public void updateCart(String str1) {
		viewProducts();
		if (carrepo.viewCart(str1)) {
			carrepo.updateCart(str1);
		} else
			logger.info("Cart is Empty");

	}

	@Override
	public void deleteCart(String str1) {
		if (carrepo.viewCart(str1)) {
			carrepo.deleteCart(str1);
		} else
			logger.info("Cart is Empty");

	}

	@Override
	public void deleteProfile(String str1) {
		if (adrepo.findUserByEmailId(str1))
			usrepo.deleteProfile(str1);
		else
			logger.info("Invalid");

	}

	@Override
	public void viewProductsBySize() {
		sc = new Scanner(System.in);
		logger.info("Enter your Size...!");
		String size = sc.next();
		if(prorepo.findProductsBySize(size)) {
			prorepo.viewProductsBysize(size);
		}
		else {
			logger.info("No products found with the mentioned size");
		}
		
	}

}
