package com.virtusa.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.course.entities.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Course set reg_stu_co=reg_stu_co+1 where course_id=?1")
	public void updatecount(int id);
	

}
