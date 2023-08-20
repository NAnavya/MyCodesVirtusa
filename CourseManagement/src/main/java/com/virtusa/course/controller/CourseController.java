package com.virtusa.course.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.course.entities.Course;
import com.virtusa.course.entities.CourseModel;
import com.virtusa.course.service.CourseService;


@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired 
	CourseService couservice;
	
	@GetMapping("/get")
	public ResponseEntity<Course> getcourse(@RequestParam("id") int couid){
		
		Course s = couservice.getCouById(couid);
		return ResponseEntity.ok(s);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> addCourse(@Valid @RequestBody CourseModel c){
		 String s1=couservice.addCourse(c);
		 return ResponseEntity.ok(s1);		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Course>> ListCourse()
	{
		List<Course> list=couservice.list_course();
		return  ResponseEntity.ok(list);
	}
	
	@PutMapping("/put/{id}")
	public ResponseEntity<String> updatestudent(@Valid @RequestBody CourseModel course,@PathVariable("id") Integer courseId)
	{
		System.out.println(courseId);
		String str=couservice.update_course(course ,courseId);
		return  ResponseEntity.ok(str);
	}
    
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletestudent(@RequestParam("id") int courseId)
	{
		String str=couservice.delete_course(courseId);
		return  ResponseEntity.ok(str);
	}

}
