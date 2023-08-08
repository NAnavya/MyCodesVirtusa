package com.virtusa.topupLoansSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.topupLoansSpring.entities.User;
import com.virtusa.topupLoansSpring.exception.PasswordNotMatchException;
import com.virtusa.topupLoansSpring.exception.UserNotFoundException;
import com.virtusa.topupLoansSpring.repo.LoanRepo;
import com.virtusa.topupLoansSpring.repo.UserRepo;

 


@Service
public class UserServiceImpl{
//	@Autowired 
//    private PasswordEncoder passwordEncoder;

    @Autowired 
       private UserRepo userRepo;
    
    @Autowired
    private LoanRepo loanrepo;
 
    public User insertUser(User user) {
        return userRepo.save(user);

    }
    
    public User addEmp(User user) {
        return  userRepo.save(user);
    }
  

 
    public List<User> getUsers() {
        // TODO Auto-generated method stub
        return userRepo.findAll();
    }
    
    public User updateUser(int id, User user) {
        // TODO Auto-generated method stub
        User user1=userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User not found"));
        if(user.getRole()=="") {
            user1.setRole("USER");
        }
        else {
        user1.setRole(user.getRole());
        }
        user1.setName(user.getName());
        if(user.getPassword().equals(user.getConPassword())) {
        user1.setPassword((user.getPassword()));
        user1.setConPassword(((user.getConPassword())));
        }
        else {
            throw new PasswordNotMatchException("Password doesnot match");
        }
        user1.setEmail(user.getEmail());
        user1.setRole(user.getRole());
         return userRepo.save(user1);
    }

 

    public String deleteUser(String email) {
        // TODO Auto-generated method stub
       // User user=userRepo.findByEmail(email);
        userRepo.deleteByEmail(email);
        return "Deleted successfully";
        }
    public String deleteLoan(String email) {
    	int a=userRepo.getidByEmail(email);
        loanrepo.deleteById(a);
        return "Deleted successfully";
        }

 
    public User getUser(String email) {
        // TODO Auto-generated method stub
        User user=userRepo.findByEmail(email);//.orElseThrow(()->new UserNotFoundException("User Not Found"));

        return user;
    }
    public String findPassByEmail(String email)
    {
    	String s=userRepo.findPassbyEmail(email);
    	return s;
    }
    public int getuserIdByEmail(String email)
    {
    	int id=userRepo.findidbyEmail(email);
    	return id;
    }
    public String getnameByEmail(String email)
    {
        String name=userRepo.findnamebyEmail(email);
    	return name;
    }
    public Optional<User> findByid(int id)
    {
    	return userRepo.findById(id);
  
    }
   public String getroleByemail(String email)
   {
	   return userRepo.getRoleByemail(email);
   }
    

}