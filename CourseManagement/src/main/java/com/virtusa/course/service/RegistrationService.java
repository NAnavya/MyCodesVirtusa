package com.virtusa.course.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.course.entities.Course;
import com.virtusa.course.entities.RegisteredCourse;
import com.virtusa.course.entities.Student;
import com.virtusa.course.exceptions.ResourceNotFoundException;
import com.virtusa.course.repository.CourseRepo;
import com.virtusa.course.repository.RegistrationRepo;
import com.virtusa.course.repository.Student_Repo;



@Service
public class RegistrationService {
	@Autowired
	Student_Repo sturepo;
	@Autowired
	CourseRepo courepo;
	@Autowired
	RegistrationRepo regrepo;

	Logger log=LoggerFactory.getLogger(RegistrationService.class);
	public String  addRegs(RegisteredCourse rc) {
		String str="";
		if(sturepo.findById(rc.getStu_id()).isPresent()&&courepo.findById(rc.getCou_id()).isPresent()) {
			System.out.println(courepo.findById(rc.getCou_id()).get().getRegStuCo()+"  /n"+courepo.findById(rc.getCou_id()).get().getLimitCouStu());
			if(courepo.findById(rc.getCou_id()).get().getRegStuCo()<courepo.findById(rc.getCou_id()).get().getLimitCouStu()) {
		Student st=sturepo.findById(rc.getStu_id()).get();
		List<Course> li=st.getLicou();
		li.add(courepo.findById(rc.getCou_id()).get());
		Course c=courepo.findById(rc.getCou_id()).get();
		courepo.updatecount(c.getCourse_id());
		st.setLicou(li);
		sturepo.save(st);
		regrepo.save(rc);
		str="Added";
		log.info("Added Successfully");
		}
			else{
				str="Registration limits Exceeds";
				log.warn("Registration limits Exceeds");
				throw new ResourceNotFoundException("Registration limits Exceeds");
				}
			}
		else {
			str="Not found with that id";
			log.warn("Not found with that id");
			throw new ResourceNotFoundException("Not found with that id");
		}
		return str;
	}

	public String upRegs(RegisteredCourse rc,int id) {
		// TODO Auto-generated method stub
		String str="";
		if(regrepo.findById(id).isPresent()) {
		RegisteredCourse rc1=regrepo.findById(rc.getReg_id()).get();
		rc1.setReg_date(rc.getReg_date());
		regrepo.save(rc1);
		str="Successfully Updated";
		log.info("Successfully Updated"+id);
		}
		else {
			str="Not found with"+id;
			log.error("Not found with"+id);
			throw new ResourceNotFoundException("Not found with"+id);
			}
		return str;
		
	}

	public String patRegs(String date,int id) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d= new Date(sdf.parse(date).getTime());
		String str="";
		if(regrepo.findById(id).isPresent()) {
			RegisteredCourse rc=regrepo.findById(id).get();
			rc.setReg_date(d);
			regrepo.save(rc);
			str="Updated Successfully";
			log.info(str);
		}
		else {
			str="Not not withthat registered id"+id;
			log.error(str);
			throw new ResourceNotFoundException("Not not withthat registered id"+id);
			
		}
		
		return str;
	}

}
