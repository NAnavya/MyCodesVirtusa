package com.virtusa.course.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;



@Entity
public class Admin {
	@Id 
	private int id;
	//NotBlank means not null and not empty(with white spaces)
	@NotBlank(message = "Name Not be neither Null nor Empty")
	private String name;
	@Email(message = "Email must be valid")
	private String mail;
	@Pattern(regexp="^.*(?=.{6,8})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^])(?=\\S+$).*$")
	private String pass;
	public Admin() {
		super();
	}
	public Admin(int id, String name, String mail, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getpass() {
		return pass;
	}
	public void setpass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", mail=" + mail + ", pass=" + pass + "]";
	}

}
