package com.virtusa.topupLoansSpring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.topupLoansSpring.dto.UserProfileDto;
import com.virtusa.topupLoansSpring.entities.UserProfile;
import com.virtusa.topupLoansSpring.service.UserProfileService;

 
@Controller
public class UserProfileController {
	@Autowired
	UserController userCon;
    @Autowired
    UserProfileService userProfileService;
      @PostMapping("/addprofile")
      public String addprofile(UserProfile userProfile){
//    	  ModelAndView mv=new ModelAndView("userProfile");
//    	  mv.addObject(userProfileDto);  
    	  System.out.println(userCon.a);
    	  String na=userCon.n;
    	  int b=userCon.a;
    	  System.out.println(userProfile);
    	  userProfile.setUserid(b);
    	  userProfile.setName(na);
    	  userProfileService.addProfile(userProfile);
          return  "WelcomeUser";
      }
      @GetMapping("/allUserProfiles")
      public ResponseEntity<List<UserProfile>> getAllUserProfiles(){
          return new ResponseEntity<>(userProfileService.getAllUserProfiles(),HttpStatus.OK);
      }

      @PutMapping("updateProfile")
      public ModelAndView updateProfileById(@RequestBody UserProfileDto userProfileDto){
    	  ModelAndView mv=new ModelAndView("updateprofile");
          int b=userCon.a;
          UserProfile userp=userProfileService.updateUserProfileById(b, userProfileDto);
          mv.addObject("addpro",userp);
          return mv;
          
      }
      
      @GetMapping("/allProfileByUserId")
      public ModelAndView getProfileByUserId(){
      	ModelAndView mv=new ModelAndView("viewprofile");
      	int b=userCon.a;
      	List<UserProfile> userp=userProfileService.getProfilebyUserId(b);
      	 List<UserProfile> userps=new ArrayList<>();
           for(UserProfile u:userp) {
           	userps.add(u);
           }
           System.out.println(b);
          userps.forEach(System.out::println);
      	mv.addObject("userps",userps);
          return mv;       
      }
      
     //Update code example 
      @RequestMapping(value="/editusers")
      public ModelAndView edit()
      {
    	  ModelAndView mv= new ModelAndView("updateProfile");
    	  int b=userCon.a;
    	  UserProfile userpro=userProfileService.getprofilebyId(b);
    	  mv.addObject("user", userpro);
    	  return mv;
      }
     
      @RequestMapping(value="/editsave",method=RequestMethod.POST)
      public ModelAndView editsave(@ModelAttribute("user") UserProfileDto userp)
      {
    	  System.out.println(userp.getUserid());
    	  userProfileService.update(userp);
    	  return new ModelAndView("WelcomeUser");
      }
      
}