package com.virtusa.course.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_id;
	@NotBlank(message = " CourseName Not be neither Null nor Empty")
	private String course_name;
    @NotBlank
	private String duration;
    private int regStuCo;
    @JsonIgnore
    @Value("${limitcount}")
    private int limitCouStu;
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	private Admin admin;

	
	public Course() {
		super();

	}
	public Course(int course_id, String course_name, String duration, Admin admin) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.duration = duration;
		this.admin = admin;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getRegStuCo() {
		return regStuCo;
	}


	

	public int getLimitCouStu() {
		return limitCouStu;
	}

	public void setLimitCouStu(int limitCouStu) {
		this.limitCouStu = limitCouStu;
	}
 
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", duration=" + duration + ", stu="
				+",regStuCo" + regStuCo +  ", admin=" + admin + "]";
	}

}
