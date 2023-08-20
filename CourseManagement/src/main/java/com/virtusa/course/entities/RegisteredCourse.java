package com.virtusa.course.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RegisteredCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reg_id;
	private int cou_id;
	private int stu_id;
	private Date reg_date;

	public RegisteredCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReg_id() {
		return reg_id;
	}

	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}

	public int getCou_id() {
		return cou_id;
	}

	public void setCou_id(int cou_id) {
		this.cou_id = cou_id;
	}

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

}
