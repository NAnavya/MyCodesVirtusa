package com.virtusa.course.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class CourseModel {
	 private int course_id;
	 private String course_name;
	 private String duration;
	 private int admin_id;
	public CourseModel() {
		super();
		
	}
	public CourseModel(int course_id, String course_name, String duration, int admin_id) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.duration = duration;
		this.admin_id = admin_id;
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
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", duration=" + duration
				+ ", admin_id=" + admin_id + "]";
	}

}
