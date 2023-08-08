package com.virtusa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.virtusa.jdbc.DatabaseConnection;

public class UserRepository {
	
	private static final String UPDATE_USERBYEMAILIDFOR_USER = "update registration set username=?,useremail=?,password=?,confirmpassword=?,userdob=? where useremail=?";
	private static final String VIEW_PRODUCTS = "select productid,productname,productsize,productquantity,productcompany,productcost from products";
	private static final String GET_USER_ID = "select userid from registration where useremail=?";
	private static final String DELETE_PROFILE = "delete from registration where userid = ?";
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	private Connection connection = DatabaseConnection.getConnection();
	Logger logger = Logger.getLogger(UserRepository.class.getName());
	Scanner sc;
	
	public void updateUserByEmailIdFromUser(String str1) {
		sc = new Scanner(System.in);
		try {
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement(UPDATE_USERBYEMAILIDFOR_USER);
			logger.info("Enter Username to update");
			stmt.setString(1, sc.nextLine());
			logger.info("Enter Email to update");
			stmt.setString(2, sc.next());
			logger.info("Enter Password to update");
			String password = sc.next();
			stmt.setString(3, password);
			logger.info("Enter Confirm Password to update");
			String confirmpassword = sc.next();
			stmt.setString(4, confirmpassword);
			if(password.equals(confirmpassword)) {
				logger.info("Enter User DOB to update");
				stmt.setString(5, sc.next());
				stmt.setString(6, str1);
				stmt.executeUpdate();
				logger.info("commiting to update .....");
				connection.commit();
				logger.info("Updated Successfully");
			}
			else {
				logger.info("Password and ConfirmPassword donot match");
			}

		} catch (SQLException e) {
			logger.info("Updation Failed");
			logger.info("rolling back .....");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				logger.info("failed!!!");
			}
		}
		
	}

	public void viewProducts() {
		try {
			stmt = connection.prepareStatement(VIEW_PRODUCTS);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				logger.info("productid ->"+rs.getInt(1)
				+"\tproductname ->"+rs.getString(2)
				+"\tproductsize ->"+rs.getString(3)
				+"\tproductquantity ->"+rs.getInt(4)
				+"\tproductcompany ->"+rs.getString(5)
				+"\tproductcost ->"+rs.getInt(6));
			}
			
		} catch (SQLException e) {
			logger.info("Failed!!");
		}
		
	}

	public void deleteProfile(String str1) {
		try {
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement(GET_USER_ID);
			stmt.setString(1, str1);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int userid = rs.getInt(1);
			stmt1 = connection.prepareStatement(DELETE_PROFILE);
			stmt1.setInt(1, userid);
			stmt1.executeUpdate();
			logger.info("Commiting data here to delete...");
			connection.commit();
			logger.info("Deleted Successfully");
		} catch (SQLException e) {
			logger.info("Failed!");
			logger.info("Rolling back ....");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				logger.info("failed!!!");
			}
		}
		
	}

	public String getUsername(String str1) {
		try {
			stmt = connection.prepareStatement("select username from registration where useremail =?");
			stmt.setString(1, str1);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			return rs.getString(1);
		} catch (SQLException e) {
			logger.info("Failed!");
		}
		return null;
	}

}
