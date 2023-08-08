package com.example.Task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Task1.entities.Emp;
import com.example.Task1.service.EmpService;

@Controller
public class EmpController {
     
	@Autowired EmpService empSer;
	@RequestMapping("/")
	public String home() {
		return "Home";
	}
	
//	@RequestMapping("/Register")
//	public ModelAndView addEmp( Emp emp) {
//		ModelAndView mv= new ModelAndView("Welcome");
//		mv.addObject("emp",emp);
//		empSer.addEmp(emp);
//	return mv;
//	}
	@RequestMapping("/Register1")
	public String Register() {
		return  "Register";
	}

	@RequestMapping("/Register")
	public Object addEmp(Emp emp) {
		try {
              empSer.addEmp(emp);
              ModelAndView mv=new ModelAndView("Welcome");
              System.out.println(emp);
              mv.addObject("emp",emp);
              return mv;
		}catch(Exception e) {
			return "UserAlready";
		}
	
	}
	
//	@RequestMapping("/Login")
//	public String getUserById(@RequestParam("id") int id,@RequestParam("Pass"))
	
}
