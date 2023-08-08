package org.virtusa.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.virtusa.aop.entities.Emp;

@Component
public class EmpDao {
	private String name;
	private String address;
	public void insertEmployee(Emp e,boolean insertFlag) {
		System.out.println(getClass()+" Inserting employee");
	}
	public boolean doSomething() {
		System.out.println(getClass()+" do something");
		return false;
	}
	public List<Emp> getEmployees(){
		List<Emp> employees=new ArrayList<>();
		employees.add(new Emp(1,"Navya","Vijayawada"));
		return employees;
		
	}
	public String getName() {
		System.out.println(getClass()+" in getName()");
		return name;
	}
	public void setName(String name) {
		System.out.println(getClass()+" in setName()");
		this.name=name;
	}
	public String getAddress() {
		System.out.println(getClass()+" in getAddress()");
		return address;
	}
	public void setAddress(String address) {
		System.out.println(getClass()+" in setAddress");
		this.address=address;
	}
}
