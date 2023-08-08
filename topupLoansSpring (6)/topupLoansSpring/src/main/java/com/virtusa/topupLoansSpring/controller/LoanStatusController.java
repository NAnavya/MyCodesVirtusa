package com.virtusa.topupLoansSpring.controller;



import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.virtusa.topupLoansSpring.entities.Loan;

import com.virtusa.topupLoansSpring.entities.LoanStatus;

import com.virtusa.topupLoansSpring.service.LoanStatusService;

 

@RestController

@RequestMapping("TopUpLoan/LoanStatusController")

public class LoanStatusController {


    @Autowired LoanStatusService loanStatusService;


    @PostMapping("/addLoanStatus/{userid}/{loanid}")

    public ResponseEntity<?> addLoanStatus(@PathVariable int userid ,@PathVariable int loanid,@RequestBody LoanStatus loanStatus){

        loanStatusService.addLoanStatus(userid,loanid,loanStatus);

        return new ResponseEntity<String>("Inserted Successfully",HttpStatus.OK);

    }

    @GetMapping("/approvedLoanStatus")

    public ResponseEntity<List<LoanStatus>> getAprrovedLoans(){

        return new ResponseEntity<List<LoanStatus>>(loanStatusService.getApprovedLoans(),HttpStatus.OK);

    }


    @GetMapping("/notApprovedLoanStatus")

    public ResponseEntity<List<LoanStatus>> getNotAprrovedLoans(){

        return new ResponseEntity<List<LoanStatus>>(loanStatusService.getNotApprovedLoans(),HttpStatus.OK);

    }


 

    

}
