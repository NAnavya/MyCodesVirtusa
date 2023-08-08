package com.example.Task1.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Task1.entities.Emp;

public interface EmpRepo extends JpaRepository<Emp,Integer>{

}
