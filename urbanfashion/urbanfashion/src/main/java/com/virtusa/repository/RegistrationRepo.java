package com.virtusa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.sql.ResultSet;

import com.virtusa.entity.RegistrationEntity;

public class RegistrationRepo {
	
	private PreparedStatement stmt = null;
	private static final String INSERT_QUERY = "insert into registration (username,useremail,password,confirmpassword,userdob,userrole) values(?,?,?,?,?,?)";
	private static final String FIND_USER = "select count(*) from registration where useremail=?";
	private static final
	Logger logger = Logger.getLogger(RegistrationRepo.class.getName());
	
	public boolean findUser(Connection connection,String useremail) throws SQLException {
		stmt = connection.prepareStatement(FIND_USER);
		stmt.setString(1,useremail);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		
		return count != 0;
	}
	

	
	public void registerUsers(Connection connection, RegistrationEntity registration){
		try {
		stmt = connection.prepareStatement(INSERT_QUERY);
		stmt.setString(1,registration.getUsername());
		stmt.setString(2, registration.getUseremail());
		stmt.setString(3, registration.getPassword());
		stmt.setString(4, registration.getConfirmpassword());
		stmt.setDate(5, registration.getUserdob());
		stmt.setString(6, registration.getUserrole());
		stmt.executeUpdate();
		}
		catch(SQLException e) {
			logger.info("Registration failed");
		}
	}
}
