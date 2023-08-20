package com.virtusa.course.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.course.entities.Student;

@Repository
public interface Student_Repo extends JpaRepository<Student,Integer> {	
		
	public Optional<Student> findByMail(String email); 


}
