package com.virtusa.course.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stu_id;
	@NotBlank(message="Name Not be neither Null nor Empty")
	private String name;
	@Email(message="Email must be valid")
	@Column(unique = true)
	private String mail;
//	@Max(10)
//	@Min(10)
	@NotBlank
	@NotEmpty
	@Pattern(regexp = "^[6-9][0-9]{9}")
	@Column(length = 10)
//	@Size(min=10,max=10)
//	@Length(min=10,max=10)
	private String phone_number;
	@Pattern(regexp = "^.*(?=.*{6,8})(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&])(?=\\S+$).*$")
	private String password;
	@Pattern(regexp = "^.*(?=.*{6,8})(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&])(?=\\S+$).*$")
	private String con_password;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Course> licou;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int stu_id, String name, String mail, String phone_number, String password, String con_password,
			List<Course> licou) {
		super();
		this.stu_id = stu_id;
		this.name = name;
		this.mail = mail;
		this.phone_number = phone_number;
		this.password = password;
		this.con_password = con_password;
		this.licou = licou;
	}

	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
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
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCon_password() {
		return con_password;
	}
	public void setCon_password(String con_password) {
		this.con_password = con_password;
	}
	
	public List<Course> getLicou() {
		return licou;
	}

	public void setLicou(List<Course> licou) {
		this.licou = licou;
	}

	@Override
	public String toString() {
		return "Student [stu_id=" + stu_id + ", name=" + name + ", mail=" + mail + ", phone_number=" + phone_number
				+ ", password=" + password + ", con_password=" + con_password + ", licou=" + licou + "]";
	}

}
