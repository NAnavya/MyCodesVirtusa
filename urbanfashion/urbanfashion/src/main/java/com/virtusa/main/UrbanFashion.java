package com.virtusa.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.virtusa.controller.LoginController;
import com.virtusa.controller.RegistrationController;
import com.virtusa.entity.RegistrationEntity;
import com.virtusa.jdbc.DatabaseConnection;

public class UrbanFashion {

	Scanner sc;
	static Logger logger = Logger.getLogger(UrbanFashion.class.getName());
	RegistrationEntity registration = new RegistrationEntity();
	RegistrationController regcontrol = new RegistrationController();
	LoginController logcontrol = new LoginController();

	public static void main(String[] args) {
		UrbanFashion obj = new UrbanFashion();
		Connection connection = DatabaseConnection.getConnection();
		try {
			if (connection != null) {
				logger.info("...........Welcome to UrbanFashion...........\n");
				obj.getData();
				
			} else {
				throw new SQLException("Database Connection not found with username or password");
			}
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}

	}

	private void getData() {
		
		sc = new Scanner(System.in);
		boolean sol = true;
		do {
			try {
				logger.info("1.Register\n2.Login\n3.Close");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					regcontrol.registration(registration);
					break;
				case 2:
					logcontrol.login();
					break;
				case 3:
					sol = false;
					logger.info("Thank You! Visit Again!!");
					break;
				default:
					logger.info("Enter Input carefully by seeing above options");
					break;
				}
			} catch (InputMismatchException e) {
				logger.info("Enter input carefully");
				sc.nextLine();
			}
		} while (sol);
		
	}

}
