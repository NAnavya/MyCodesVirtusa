package com.virtusa.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.virtusa.repository.UserRepository;
import com.virtusa.service.UserService;
import com.virtusa.service.UserServiceImplementation;

public class UserController {

	Logger logger = Logger.getLogger(UserController.class.getName());
	Scanner sc;

	public void user(String str1) {

		UserService service = new UserServiceImplementation();
		UserRepository usrepo = new UserRepository();
		String username = usrepo.getUsername(str1);
		logger.log(java.util.logging.Level.SEVERE, "Welcome User:....... {0}", username);
		boolean sol = true;
		while (sol) {
			try {
				sc = new Scanner(System.in);
				logger.info("1.View Products" + "\n2.Add Products To Cart" + "\n3.View cart" + "\n4.Product Booking"
						+ "\n5.Update your Cart" + "\n6.Delete Products from Cart" + "\n7.Update your Profile"
						+ "\n8.View Profile" + "\n9.Delete Profile" + "\n10.Logout");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					service.viewProducts();
					break;
				case 2:
					service.addProductsToCart(str1);
					break;
				case 3:
					service.viewCart(str1);
					service.getMetaData();
					break;
				case 4:
					logger.info("...Payment Processing...");
					service.bookProducts(str1);
					break;
				case 5:
					logger.info("...Updation Initiated...");
					service.updateCart(str1);
					break;
				case 6:
					service.deleteCart(str1);
					break;
				case 7:
					service.updateProfile(str1);
					break;
				case 8:
					service.viewProfile(str1);
					break;
				case 9:
					service.deleteProfile(str1);
					sol = false;
					break;
				case 10:
					String uname = usrepo.getUsername(str1);
					logger.log(java.util.logging.Level.SEVERE, "User:....... {0}", uname);
					logger.info("Logged Out");
					sol = false;
					break;
				default:
					logger.info("enter input carefully");
					break;
				}
			} catch (InputMismatchException e) {
				logger.info("enter input carefully");
				sc.nextLine();
			}
		}
	}

}
