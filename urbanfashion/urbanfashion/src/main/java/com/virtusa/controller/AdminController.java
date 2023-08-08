package com.virtusa.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.virtusa.entity.RegistrationEntity;
import com.virtusa.service.AdminService;
import com.virtusa.service.AdminServiceImplementation;
import com.virtusa.service.ProductService;
import com.virtusa.service.ProductServiceImplementation;

public class AdminController {

	Logger logger = Logger.getLogger(AdminController.class.getName());
	Scanner sc;

	public void admin(String str1) {

		logger.info("Welcome ADMIN....\n");

		RegistrationEntity registration = new RegistrationEntity();
		AddingAdminController addingadmin = new AddingAdminController();
		AdminService service = new AdminServiceImplementation();
		ProductController procon = new ProductController();
		ProductService proservice = new ProductServiceImplementation();
		boolean sol = true;
		sc = new Scanner(System.in);
		
			while (sol) {
				try {
				logger.info(
						"1.ADD ADMIN" + "\n2.View Users" + "\n3.Update User by Email id" + "\n4.Delete User by Email id"
								+ "\n5.Add Products" + "\n6.View Products" + "\n7.Update Products by id"
								+ "\n8.Delete Products by id" + "\n9.View Users with their cart" + "\n10.Logout");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					addingadmin.addAdmin(registration);
					break;
				case 2:
					boolean op = true;
					while (op) {
						logger.info("1.view all users" + "\n2.view users sorted by name"
								+ "\n3.view users limited by limited number" + "\n4.Close view");
						int option = sc.nextInt();
						switch (option) {
						case 1:
							service.viewAllUsers(registration);
							break;
						case 2:
							service.sortUsersByName();
							break;
						case 3:
							service.viewUsersByLimit();
							break;
						case 4:
							op = false;
							break;
						default:
							break;
						}
					}
					break;
				case 3:
					service.updateUsers(registration);
					break;
				case 4:
					service.deleteUsers();
					break;
				case 5:
					procon.addProducts(str1);
					break;
				case 6:
					proservice.viewProducts();
					break;
				case 7:
					proservice.updateProducts();
					break;
				case 8:
					proservice.deleteProducts();
					break;
				case 9:
					service.viewUsersWithCart();
					break;
				case 10:
					sol = false;
					logger.info("Admin logged out!!");
					break;
				default:
					logger.info("Enter input carefully by seeing above options");
					break;
				}
			}
				catch (InputMismatchException e) {
					logger.info("Enter input carefully");
					sc.nextLine();
				}
		} 

	}

}
