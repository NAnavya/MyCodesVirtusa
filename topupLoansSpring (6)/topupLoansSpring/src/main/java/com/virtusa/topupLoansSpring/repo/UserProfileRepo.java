package com.virtusa.topupLoansSpring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.virtusa.topupLoansSpring.dto.UserProfileDto;
import com.virtusa.topupLoansSpring.entities.Loan;
import com.virtusa.topupLoansSpring.entities.UserProfile;

 

public interface UserProfileRepo extends CrudRepository<UserProfile,Integer> {
	@Query(value="select * from user_profile where userid = ?1",nativeQuery =true)
	List<UserProfile> findPByUserId(Integer userid);
	
	@Query(value="select userid, aadhar, salary, name, pan, address from topuploanspring2.user_profile where userid = ?1",nativeQuery =true)
	UserProfile getProfilebyId(int id);
	
	

}

 

