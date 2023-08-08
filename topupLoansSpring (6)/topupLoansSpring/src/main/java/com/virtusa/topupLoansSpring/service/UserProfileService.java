package com.virtusa.topupLoansSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.topupLoansSpring.dto.UserProfileDto;
import com.virtusa.topupLoansSpring.entities.UserProfile;
import com.virtusa.topupLoansSpring.exception.UserNotFoundException;
import com.virtusa.topupLoansSpring.repo.LoanRepo;
import com.virtusa.topupLoansSpring.repo.LoanStatusRepo;
import com.virtusa.topupLoansSpring.repo.UserProfileRepo;
import com.virtusa.topupLoansSpring.repo.UserRepo;

 

@Service
public class UserProfileService {

 
    @Autowired
    UserProfileRepo userProfileRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    LoanRepo loanRepo;
    @Autowired
    LoanStatusRepo laonStatusRepo;
    public UserProfile addProfile(UserProfile userProfile) {
        return userProfileRepo.save(userProfile);

    }
    public List<UserProfile> getAllUserProfiles(){
        return (List<UserProfile>) userProfileRepo.findAll();
    }
    public UserProfile updateUserProfileById(int userid,UserProfileDto userProfileDto) {
        // TODO Auto-generated method stub
        UserProfile userProfile1=userProfileRepo.findById(userid).orElseThrow(()->new UserNotFoundException("user Not Found"));
        userProfile1.setAadhar(userProfileDto.getAadhar());
        userProfile1.setAddress(userProfileDto.getAddress());
        userProfile1.setPan(userProfileDto.getPan());
        userProfile1.setSalary(userProfileDto.getSalary());
        

        return userProfileRepo.save(userProfile1) ;
    }
    
    public List<UserProfile>getProfilebyUserId(int userid) {
        return (List<UserProfile>) userProfileRepo.findPByUserId(userid);
    }
    public String deleteUserP(int a) {
    	//int a=userRepo.getidByEmail(email);
    	        userProfileRepo.deleteById(a);
    	        return "Deleted successfully";
    	        }
    
    public UserProfile getprofilebyId(int id)
    {
    	UserProfile user=userProfileRepo.getProfilebyId(id);
    	return user;
    }
    public UserProfile update(UserProfileDto userProfileDto)
    {
       UserProfile userProfile1=new UserProfile();
       userProfile1.setUserid(userProfileDto.getUserid());
       userProfile1.setName(userProfileDto.getName());
        userProfile1.setAadhar(userProfileDto.getAadhar());
        userProfile1.setAddress(userProfileDto.getAddress());
        userProfile1.setPan(userProfileDto.getPan());
        userProfile1.setSalary(userProfileDto.getSalary());
        return userProfileRepo.save(userProfile1) ;
        
    }
    
    
}
