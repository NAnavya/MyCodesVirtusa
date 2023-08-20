package com.virtusa.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.course.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer> {

}
