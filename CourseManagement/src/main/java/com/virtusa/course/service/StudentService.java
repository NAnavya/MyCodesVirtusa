package com.virtusa.course.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.course.entities.Student;
import com.virtusa.course.entities.StudentModel;
import com.virtusa.course.exceptions.ResourceNotFoundException;
import com.virtusa.course.repository.Student_Repo;

@Service
public class StudentService {
	public static final String PASS_REGEX = "^.*(?=.{6,})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&])(?=\\S+$).*$";
	Logger log = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	Student_Repo stu_repo;
	ModelMapper mp = new ModelMapper();

	public Student getStuById(int id) {

		Optional<Student> s = stu_repo.findById(id);
		if (s.isPresent()) {
			return s.get();
		} else {
			log.warn("Student doesnot found with " + id);
		    throw new ResourceNotFoundException("Student doesnot found with " + id);
		}
	}

	public String postStu(StudentModel stu) {
		if(!(stu_repo.findByMail(stu.getMail()).isPresent())) {
		if (stu.getPassword().equals(stu.getCon_password())) {
			if (stu.getPassword().matches(PASS_REGEX)) {
				Student s = mp.map(stu, Student.class);
				Student s1 = stu_repo.save(s);
				return s1.toString();
			} else {
				log.warn("Password doesnot meet the criteria ");
				return "Password doesnot meet the criteria ";
			}
		} else {
			log.warn("Password Doesnot match");
			return "Password Doesnot match";
		}
		}
		else {
			log.warn("Student not found with"+stu.getStu_id());
			return ("Student not found with"+stu.getStu_id());
		}
	}

	public List<Student> list_student() {

		List<Student> l = stu_repo.findAll();
		return l;

	}

	public String update_stu(StudentModel stu, int stuid) {
		String rstr = "";
		Optional<Student> s2 = stu_repo.findById(stuid);

		if (s2.isPresent()) {
			Student so = s2.get();
			if (stu.getPassword().equals(stu.getCon_password())) {
				if (stu.getPassword().matches(PASS_REGEX)) {

					so.setCon_password(stu.getCon_password());
					so.setPassword(stu.getPassword());
					so.setMail(stu.getMail());
					so.setName(stu.getName());
					so.setPhone_number(stu.getPhone_number());
					stu_repo.save(so);
					rstr = so.toString();
				} else {
					log.warn("Password doesnot meet the criteria ");
					rstr = "Password doesnot meet the criteria ";
				}
			} else {
				log.warn("Password Doesnot match");
				rstr = "Password Doesnot match";
			}
		} else {
			throw new ResourceNotFoundException("Not Found Student with that id");
		}
		log.info("Successfully Updated" + stuid);
		return rstr;
	}

	public String delete_stu(int stuid) {
		Optional<Student> s2 = stu_repo.findById(stuid);
		if (s2.isPresent()) {
			stu_repo.deleteById(stuid);
		} else {
			log.warn("Not Found Student with " + stuid);
			throw new ResourceNotFoundException("Not Found Student with " + stuid);
		}
		log.info("Deleted Successfully" + stuid);
		return "Deleted Successfully";
	}
}
