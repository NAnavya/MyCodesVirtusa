package com.virtusa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.virtusa.jdbc.DatabaseConnection;

public class LoginRepository {
	
	private static final String VALIDATE_QUERY = "select count(*),userrole from registration where useremail = ? and password =? group by(userrole)";
	PreparedStatement stmt = null;
	Connection  connection = DatabaseConnection.getConnection();
	Logger logger = Logger.getLogger(LoginRepository.class.getName());

	public String check(String str1, String str2){
		
		try {
			stmt = connection.prepareStatement(VALIDATE_QUERY);
			stmt.setString(1, str1);
			stmt.setString(2, str2);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			String str = rs.getString(2);
			if(count > 0)
				return str;
		} catch (SQLException e) {
			logger.info("Login Invalid\nInvalid Credentials");
		}
		return null;
	}
}