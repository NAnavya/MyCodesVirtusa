package com.virtusa.course.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.course.entities.Student;
import com.virtusa.course.entities.StudentModel;
import com.virtusa.course.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired 
	StudentService stuservice;
	
	@GetMapping("/get")
	public ResponseEntity<Student> getstudent(@RequestParam("id") int stuid){	
		Student s=stuservice.getStuById(stuid);
		return ResponseEntity.ok(s);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> addstudent(@Valid @RequestBody StudentModel stu){
		
		 String s1=stuservice.postStu(stu);
		 return ResponseEntity.ok(s1);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> ListStudent()
	{
		List<Student> list=stuservice.list_student();
		return  ResponseEntity.ok(list);
	}
	
	@PutMapping("/put")
	public ResponseEntity<String> updatestudent(@Valid @RequestBody StudentModel stu1,@RequestParam("id") int stuid)
	{
		String str=stuservice.update_stu(stu1 ,stuid);
		return  ResponseEntity.ok(str);
	}
    
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletestudent(@RequestParam("id") int stuid)
	{
		String str=stuservice.delete_stu(stuid);
		return  ResponseEntity.ok(str);
	}
	
}
