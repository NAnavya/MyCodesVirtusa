package com.virtusa.course.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StudentModel {

	private int stu_id;
	private String name;
	private String mail;
	private String phone_number;
	private String password;
	private String con_password;
	@JsonIgnore
	private List<Integer> licou_id;
	public StudentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentModel(int stu_id, String name, String mail, String phone_number, String password, String con_password,
			List<Integer> licou_id) {
		super();
		this.stu_id = stu_id;
		this.name = name;
		this.mail = mail;
		this.phone_number = phone_number;
		this.password = password;
		this.con_password = con_password;
		this.licou_id = licou_id;
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
	
	public List<Integer> getLicou() {
		return licou_id;
	}

	public void setLicou(List<Integer> licou_id) {
		this.licou_id = licou_id;
	}

	@Override
	public String toString() {
		return "Student [stu_id=" + stu_id + ", name=" + name + ", mail=" + mail + ", phone_number=" + phone_number
				+ ", password=" + password + ", con_password=" + con_password + ", licou=" + licou_id + "]";
	}

}
