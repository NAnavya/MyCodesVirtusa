package com.virtusa.topupLoansSpring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.topupLoansSpring.entities.Loan;
import com.virtusa.topupLoansSpring.entities.User;
import com.virtusa.topupLoansSpring.service.LoanService;
import com.virtusa.topupLoansSpring.service.UserProfileService;
import com.virtusa.topupLoansSpring.service.UserServiceImpl;

 

@RestController
public class Loancontroller {

    @Autowired LoanService loanService;
    
    @Autowired UserServiceImpl uprepo;
    @Autowired UserController usercon;
    @Autowired UserProfileService userpservice;

    

    @PostMapping("/addLoan")
    public ModelAndView addLoan(@ModelAttribute Loan loans){
    	ModelAndView mv=new ModelAndView("WelcomeUser");
    	Loan loan1=new Loan();
    	int b=usercon.a;
    	System.out.println(b);
    	User userp=uprepo.findByid(b).orElseThrow();
    	System.out.println(userp);
    	int s=loans.getSpan();
    	long amount=loans.getAmount_needed();
    	int em=(int) (amount/s);
    	loan1.setId(loans.getEmi());
    	loan1.setLoanType(loans.getLoanType()); 
    	loan1.setSalary(loans.getSalary());
    	loan1.setAmount_needed(loans.getAmount_needed());
    	loan1.setStatus("Applied");
    	loan1.setEmi(em);
    	loan1.setSpan(loans.getSpan());
    	
    	loan1.setUser(userp);
    	System.out.println(loans.getUser());
         loanService.addLoan(loan1);
       // mv.addObject("loan",loan);
        return mv;
    }

    @GetMapping("/getLoanById/{loanid}")
    public ResponseEntity<Loan> getLoanById(@PathVariable int loanid){
        return new ResponseEntity<Loan>(loanService.getLoanbyId(loanid),HttpStatus.OK);
    }

    @PutMapping("updateLoan/{loanid}")
    public ResponseEntity<Loan> upadateLoan(@PathVariable int loanid,@RequestBody Loan loan){
        return new ResponseEntity<Loan>(loanService.updateLoanById(loanid,loan),HttpStatus.OK);
    }

    
    @GetMapping("/allLoanByUserId")
    public ModelAndView getLoanByUserId(){
    	ModelAndView mv=new ModelAndView("loandetails");
    	int b=usercon.a;
    	List<Loan> loan=loanService.getLoanbyUserId(b);
    	 List<Loan> loans=new ArrayList<>();
         for(Loan u:loan) {
         	loans.add(u);
         }
        loans.forEach(System.out::println);
    	mv.addObject("loans",loans);
        return mv;    
    }
    @GetMapping("/allloan")
    public ModelAndView getLoans(){
    	ModelAndView mv=new ModelAndView("viewLoans");
        List<Loan> loan=loanService.getLoans();
        List<Loan> loans=new ArrayList<>();
        for(Loan u:loan) {
          	loans.add(u);
        }
       	
        loans.forEach(System.out::println);
    	mv.addObject("loans",loans);
        return mv;    
    }
    
    //example code 
    
    @RequestMapping(value="/saveloan/{id}")
    public ModelAndView editloan(@PathVariable int id)
    {
    	ModelAndView mv=new ModelAndView("updateloan");
  	  Loan loan=loanService.getLoanbyId(id);
  	  mv.addObject("loan", loan);
  	  return mv;
    }
   
    @RequestMapping(value="/saveloan")
    public ModelAndView saveloan(@ModelAttribute("loan") Loan loans)
    {
  	  System.out.println(loans.getId());
  	  int a=loans.getId();
  	  loanService.update(a,loans);
  	  return new ModelAndView("WelcomeUser");
    }
    
    @RequestMapping(value="/deleteloan")
    public ModelAndView deleteloan(@ModelAttribute("loan") Loan loans)
    {
  	  System.out.println(loans.getId());
  	  int a=loans.getId();
  	  loanService.deleteById(a);
  	  return new ModelAndView("WelcomeUser");
    }
  
     
}
