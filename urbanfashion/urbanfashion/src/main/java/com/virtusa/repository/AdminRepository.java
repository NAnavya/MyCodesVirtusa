package com.virtusa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.virtusa.entity.RegistrationEntity;
import com.virtusa.jdbc.DatabaseConnection;

public class AdminRepository {

	private static final String USER_EXISTS = "select count(*) from registration";
	private static final String USERS = "select * from registration";
	private static final String FIND_USEREMAILID = "select count(*) from registration where useremail = ?";
	private static final String SELECT_USERBYEMAILID = "select username,useremail,password,userdob from registration where useremail =?";
	private static final String UPDATE_USERBYEMAILIDFOR_ADMIN = "update registration set username=?,useremail=?,userdob=?,userrole=? where useremail=?";

	private Connection connection = DatabaseConnection.getConnection();
	private PreparedStatement stmt = null;
	Scanner sc;
	
	Logger logger = Logger.getLogger(AdminRepository.class.getName());
	RegistrationEntity registration = new RegistrationEntity(); 

	public boolean findUserByEmailId(String checkemail) {

		try {
			stmt = connection.prepareStatement(FIND_USEREMAILID);
			stmt.setString(1, checkemail);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if(count!=0)
				return true;

		} catch (SQLException e) {
			logger.info("Email id Not Found");
		}

		return false;
	}

	public boolean usersExist() {

		try {
			stmt = connection.prepareStatement(USER_EXISTS);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if(count!=0)
				return true;
		} catch (SQLException e) {
			logger.info("Invalid !!");
		}

		return false;
	}

	public List<RegistrationEntity> viewUsers() {
		List<RegistrationEntity> list = new ArrayList<>();
		RegistrationEntity registration = null;
		try {
			stmt = connection.prepareStatement(USERS);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				registration = new RegistrationEntity();
				registration.setUserid(rs.getInt(1));
				registration.setUsername(rs.getString(2));
				registration.setUseremail(rs.getString(3));
				registration.setUserdob(rs.getDate(6));
				registration.setUserrole(rs.getString(7));
				list.add(registration);
			}

		} catch (SQLException e) {
			logger.info("Invalid");
		}
		return list;
	}

	public boolean viewUserByEmailId(String checkemail) {

		try {
			stmt = connection.prepareStatement(SELECT_USERBYEMAILID);
			stmt.setString(1, checkemail);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				logger.info("Username -> "+rs.getString(1)+
						", Useremail -> "+rs.getString(2)+
						", password -> "+rs.getString(3)+
						", Userdob -> "+rs.getDate(4));
				return true;
			}



		} catch (SQLException e) {
			logger.info("User Not Found");
		}
		return false;
	}

	public void updateUserByEmailIdFromAdmin(String checkemail) {
		sc = new Scanner(System.in);
		try {
			stmt = connection.prepareStatement(UPDATE_USERBYEMAILIDFOR_ADMIN);
			logger.info("Enter Username to update");
			stmt.setString(1, sc.nextLine());
			logger.info("Enter Email to update");
			stmt.setString(2, sc.next());
			logger.info("Enter User DOB to update");
			stmt.setString(3, sc.next());
			logger.info("Enter User role to update");
			stmt.setString(4, sc.next());
			stmt.setString(5, checkemail);
			stmt.executeUpdate();
			logger.info("Updated Successfully");

		} catch (SQLException e) {
			logger.info("Updation Failed");
		}


	}

	

	public void viewUsersWithCart() {
		
		try {
			stmt = connection.prepareStatement("select registration.userid,registration.username,registration.useremail,cart.productname,cart.productquantity,cart.cost from registration join cart on registration.userid = cart.userid");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				logger.info("userid -> "+rs.getInt(1)
				+"\tusername -> "+rs.getString(2)
				+"\tuseremail -> "+rs.getString(3)
				+"\tproductname -> "+rs.getString(4)
				+"\tproductquantity -> "+rs.getInt(5)
				+"\tproductcost -> "+rs.getInt(6));
				
			}

		} catch (SQLException e) {
			logger.info("Failed!!");
		}
		
	}

	public void sortUsersByName() {
		
		try {
			stmt = connection.prepareStatement(USERS);
			ResultSet rs = stmt.executeQuery();
			List<RegistrationEntity> list = new ArrayList<>();
			while(rs.next()) {
				list.add(new RegistrationEntity(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						null,null,
						rs.getDate(6),
						rs.getString(7)));
			}
			Collections.sort(list,new CusCom());
			logger.log(java.util.logging.Level.SEVERE, "{0}\n", list);
		} catch (SQLException e) {
			logger.info("Failed!!");
		}
		
	}

	public boolean viewUsersByLimit(int nr) {
		try {
			int count = countUsers();
			if(nr<=count) {
				stmt = connection.prepareStatement("select userid,username,useremail,userdob,userrole from registration limit ?");
				stmt.setInt(1,nr);
				ResultSet rs1 = stmt.executeQuery();
				while(rs1.next()) {
					logger.info("userid ->"+rs1.getInt(1) 
					+"\tusername ->"+rs1.getString(2)+ 
					"\tuseremail ->"+rs1.getString(3)+
					"\tuserdob ->"+rs1.getDate(4)+
					"\tuserrole ->"+rs1.getString(5));
				}
				return true;
			}
		} catch (SQLException e) {
			logger.info("Failed!");
		}
		return false;
	}

	public boolean cartExist() {
		try {
			stmt = connection.prepareStatement("select count(*) from cart");
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if(count>0) {
				return true;
			}
		} catch (SQLException e) {
			logger.info("failed");
		}
		return false;
	}
	
	public int countUsers() {
		try {
			stmt = connection.prepareStatement(USER_EXISTS);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if(count > 0)
				return count;
		} catch (SQLException e) {
			logger.info("Failed!");
		}
		return 0;
	}

}
