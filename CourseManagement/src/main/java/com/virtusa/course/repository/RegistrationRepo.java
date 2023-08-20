package com.virtusa.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.course.entities.RegisteredCourse;

public interface RegistrationRepo extends JpaRepository<RegisteredCourse,Integer>{

}
