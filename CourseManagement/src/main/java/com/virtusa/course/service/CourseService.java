package com.virtusa.course.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.virtusa.course.entities.Course;
import com.virtusa.course.entities.CourseModel;
import com.virtusa.course.exceptions.ResourceNotFoundException;
import com.virtusa.course.repository.AdminRepo;
import com.virtusa.course.repository.CourseRepo;


@Service
public class CourseService {
	Logger log=LoggerFactory.getLogger(CourseService.class);
	@Autowired
	CourseRepo courepo;
	@Autowired
	AdminRepo ar;
    @Value("${limitcount}")
    private int count;
	
	public Course getCouById(int couid) 
	{
		//System.out.println(count);
		
		if(courepo.existsById(couid))
		{
       Course c=courepo.findById(couid).get();
       return c;
		}
		else
		{
			log.error("Not Found course with this id "+couid );
			throw new ResourceNotFoundException("Not Found course with this id "+couid );
		}
		
}

	public String addCourse(CourseModel c) 
	{
		String str="";
		if(courepo.findById(c.getCourse_id()).isEmpty()) {
		Course c1=new Course();
	    c1.setAdmin(ar.findById(c.getAdmin_id()).orElseThrow());
	    c1.setCourse_name(c.getCourse_name());
	    c1.setDuration(c.getDuration());
	    c1.setLimitCouStu(count);
		courepo.save(c1);
		str="Added Successfully";
		log.info("Added Successfully");
		}
		else {
			str="Course already Exist";
		}
		return str;
	}

	public List<Course> list_course()
	{
	
		List<Course> c1=courepo.findAll();
		return c1;
	}

	public String update_course(CourseModel course, int courseId)
	{
		String str="";
		if(courepo.findById(courseId).isPresent()) {
		Course c1=courepo.findById(course.getCourse_id()).get();
		c1.setAdmin(ar.findById(course.getAdmin_id()).get());
		c1.setCourse_name(course.getCourse_name());
		c1.setDuration(course.getDuration());
			courepo.save(c1);
			log.info("Added Successfully");
			str="Course updated successfullly";
		}	
		else
		{
			log.error("Course not found with "+courseId);
			str=("Course not found with "+courseId);
			throw new ResourceNotFoundException("course not found with this id");
		}
		return str;
	}

	public String delete_course(int courseId) {
	
		Optional<Course> c=courepo.findById(courseId);
		 String str="";
		if(c.isPresent())
		{
			courepo.deleteById(courseId);
			log.info("Successfully Deleted");
			str="deleted successfully";
		}
		else
		{    
			str="course not found with this id"+courseId;
			log.error("course not found with this id"+courseId);
			throw new ResourceNotFoundException("course not found with this id"+courseId);
		}
		return str ;
	}


	

}

