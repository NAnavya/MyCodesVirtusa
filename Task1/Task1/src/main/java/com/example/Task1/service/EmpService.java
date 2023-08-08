package com.example.Task1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task1.entities.Emp;
import com.example.Task1.repo.EmpRepo;

@Service
public class EmpService {
	@Autowired
	private EmpRepo empRepo;
	
	public void addEmp(Emp emp) {
	       empRepo.save(emp);
	}

	public Emp updateEmpById(int id,Emp emp) {
		// TODO Auto-generated method stub
	      Emp e=empRepo.findById(id).orElseThrow();
   		 e.setId(emp.getId());
   		 e.setName(emp.getName());
   		 e.setSal(emp.getSal());
   		 e.setSal(emp.getSal());
		return empRepo.save(e);
	}

	public List<Emp> getAll() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}
	
	public Emp getEmpById(int id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).orElseThrow();
	}

}
