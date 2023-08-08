package com.virtusa.entity;

import java.sql.Date;

public class RegistrationEntity {
	
	private int userid;
	private String username;
	private String useremail;
	private String password;
	private String confirmpassword;
	private Date userdob;
	private String userrole;
	
	public RegistrationEntity(int userid, String username, String useremail, String password, String confirmpassword,
			Date userdob, String userrole) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.userdob = userdob;
		this.userrole = userrole;
	}
	
	public RegistrationEntity() {
		
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public Date getUserdob() {
		return userdob;
	}

	public void setUserdob(Date userdob) {
		this.userdob = userdob;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", useremail=" + useremail
				+ ", userdob=" + userdob
				+ ", userrole=" + userrole + "]";
	}
	
	
	
}
