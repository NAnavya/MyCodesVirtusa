package com.virtusa.topupLoansSpring.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.topupLoansSpring.entities.User;
import com.virtusa.topupLoansSpring.exception.UserAlreadyExistsException;
import com.virtusa.topupLoansSpring.exception.UserNotFoundException;
import com.virtusa.topupLoansSpring.repo.UserRepo;
import com.virtusa.topupLoansSpring.service.LoanService;
//import com.virtusa.topupLoansSpring.service.UserPrinciple;
import com.virtusa.topupLoansSpring.service.UserProfileService;
import com.virtusa.topupLoansSpring.service.UserServiceImpl;

 

@Controller



public class UserController {

     public static int a;
     public static String n;

    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private UserRepo userRepo;
   

   // private UserPrinciple userp;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private UserProfileService userprofileservice;
    
    @Autowired
    private LoanService loanservice;
    
     @RequestMapping("/home")
     public String home() {
    	 return "Home";
     }

    @PostMapping("/addUser")
    public String insertUser(@ModelAttribute User user) {
    	String email=user.getEmail();
    	String st=userServiceImpl.getroleByemail(email);
    	if(st==null) {
    	user.setRole("user");
    	String pass=user.getPassword();
    	String pass1=user.getConPassword();
    	if(pass.equals(pass1)) {
    	String epass=passwordEncoder.encode(pass);
    	user.setPassword(epass);
    	
    	
    	String epass1=passwordEncoder.encode(pass);
    	user.setConPassword(epass1);
    	 String pwd=user.getPassword();
    	 String pwd1=user.getConPassword();
    	
        userServiceImpl.insertUser(user);}
        System.out.println(user);
        return "Home";}
    	else
    		throw new UserAlreadyExistsException("User Not Found");
    }
    @PostMapping("/addEmp")
    public String addEmp(@ModelAttribute User user){
    	user.setRole("admin");
    	String pass=user.getPassword();
    	String pass1=user.getConPassword();
    	if(pass.equals(pass1)) {
    	String epass=passwordEncoder.encode(pass);
    	user.setPassword(epass);
    	
    	
    	String epass1=passwordEncoder.encode(pass);
    	user.setConPassword(epass1);
    	 String pwd=user.getPassword();
    	 String pwd1=user.getConPassword();
    	
    	 userServiceImpl.addEmp(user);}
    	 System.out.println(user);
        return "addEmp";
    } 
//    @GetMapping("/login")
//    public Object login(@RequestParam("email") String email,@RequestParam("password") String password) {
//    	User user=userServiceImpl.getUser(email);
//    	String name=user.getName();
//    	a=user.getId();
//    	n=user.getName();
//    	System.out.println(a);
//    	System.out.println(name);
//    	System.out.println(user.getRole());
//    	String pass=userServiceImpl.findPassByEmail(email);
//    	if(password.equals(pass)) {
//    	if((user.getRole().equals("user")||user.getRole().equals("USER"))) {
//    	ModelAndView mv=new ModelAndView("WelcomeUser");
//    	mv.addObject("user",user);
//    	return mv;
//    	}
//    	else {
//    		ModelAndView mv=new ModelAndView("WelcomeAdmin");
//        	mv.addObject("user",user);
//        	return mv;
//    	}}
//    	else
//    	{
//    	   throw new UserNotFoundException("User Not Found");	
//    	}
//    }
    @RequestMapping("/login")
    public Object loginpage(@ModelAttribute User user)
    {
    	String em=user.getEmail();
    	a=userServiceImpl.getuserIdByEmail(em);
    	n=userServiceImpl.getnameByEmail(em);
    	System.out.println(a);
    	String pas=user.getPassword();
    	String pass1=userRepo.findPassbyEmail(em);
    	System.out.println(pas);
    	System.out.println(pass1);
    	String role=userServiceImpl.getroleByemail(em);
    	System.out.println(role);
    	if(passwordEncoder.matches(pas,pass1)&&role.equals("user")) {
        	ModelAndView mv=new ModelAndView("WelcomeUser");
        	mv.addObject("user",user);
        	return mv;
        	}
    	else if(passwordEncoder.matches(pas,pass1)&&role.equals("admin")) {
    		ModelAndView mv=new ModelAndView("WelcomeAdmin");
        	mv.addObject("user",user);
        	return mv;
    	}
    	else
    		throw new UserNotFoundException("User Not Found");
    	
    }
    @GetMapping("/alluser")
    public ModelAndView getUsers(){
    	ModelAndView mv=new ModelAndView("viewUsers");
        List<User> user=userServiceImpl.getUsers();
        List<User> users=new ArrayList<>();
        for(User u:user) {
        	if(u.getRole().equalsIgnoreCase("user"))
        	users.add(u);
        }
       	
        users.forEach(System.out::println);
    	mv.addObject("users",users);
        return mv;    
    }
    @GetMapping("/alladmin")
    public ModelAndView getAdmin(){
    	ModelAndView mv=new ModelAndView("viewAdmins");
        List<User> admin=userServiceImpl.getUsers();
        List<User> admins=new ArrayList<>();
        for(User u:admin) {
        	if(u.getRole().equalsIgnoreCase("admin"))
        	admins.add(u);
        }
        	
        admins.forEach(System.out::println);
    	mv.addObject("admins",admins);
        return mv;    
    }
    @PutMapping("/updateuser")
    public ResponseEntity<User> updateUser(@RequestBody User user){
     return new ResponseEntity<>(userServiceImpl.updateUser(a,user),HttpStatus.OK);
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("email") String email){
    	int a=userServiceImpl.getuserIdByEmail(email);
    	 loanservice.deleteLoanById(a);
    
    	  userprofileservice.deleteUserP(a);
         userServiceImpl.deleteUser(email);
       
         
         return "WelcomeAdmin";
    }
    
    @RequestMapping("/deleteAdmin")
    public String deleteAdmin(@RequestParam("email") String email){
    	int a=userServiceImpl.getuserIdByEmail(email);
         userServiceImpl.deleteUser(email);
         return "WelcomeAdmin";
    }
    
    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(){
    	User u=userRepo.findById(a).orElseThrow();
    	System.out.println(u);
    	 String email=u.getEmail();
        return new ResponseEntity<User>(userServiceImpl.getUser(email),HttpStatus.OK);
    }
     
    
}
