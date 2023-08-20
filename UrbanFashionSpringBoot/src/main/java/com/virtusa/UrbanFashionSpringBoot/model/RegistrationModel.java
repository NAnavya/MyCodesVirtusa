package com.virtusa.UrbanFashionSpringBoot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class RegistrationModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String uname;
	@Column(unique=true)
	private String uemail;
	private String role;
	private String password;
	private String cpassword;

	public RegistrationModel() {
		super();
	}

	public RegistrationModel(int uid, String uname, String uemail, String role) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uemail = uemail;
		this.role = role;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	@Override
	public String toString() {
		return "RegistrationModel [uid=" + uid + ", uname=" + uname + ", uemail=" + uemail + ", role=" + role
				+ ", password=" + password + ", cpassword=" + cpassword + "]";
	}
	
	
	
	
	

}
