package com.virtusa.topupLoansSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.topupLoansSpring.dto.UserProfileDto;
import com.virtusa.topupLoansSpring.entities.Loan;
import com.virtusa.topupLoansSpring.entities.UserProfile;
import com.virtusa.topupLoansSpring.exception.LoanNotFoundException;
import com.virtusa.topupLoansSpring.repo.LoanRepo;

 

@Service
public class LoanService {
    @Autowired LoanRepo loanRepo;
    public Loan addLoan(Loan loan) {
        return  loanRepo.save(loan);
    }
    public List<Loan> getLoans() {
        return (List<Loan>) loanRepo.findAll();
    }
    public Loan getLoanbyId(int loanid) {
        return loanRepo.findById(loanid).orElseThrow(()->new LoanNotFoundException("Loan Not Found"));
    }
    public List<Loan> getLoanbyUserId(int userid) {
        return (List<Loan>) loanRepo.findByUserId(userid);
    }
    public Loan updateLoanById(int loanid,Loan loan) {
        Loan loan1=loanRepo.findById(loanid).orElseThrow(()-> new LoanNotFoundException("Loan Not Found"));
        loan1.setLoanType(loan.getLoanType());
        loan1.setSpan(loan.getSpan());
        return loanRepo.save(loan1);
    }
    public void deleteLoanById(int userid) {
        loanRepo.deleteByuserId(userid);
    }
    public int getIdbyUserid(int uid)
    {
    	return loanRepo.getidbyuid(uid);
    }
    public Loan update(int loanid,Loan loan)
    {
    	 Loan loan1=loanRepo.findById(loanid).orElseThrow(()-> new LoanNotFoundException("Loan Not Found"));
         loan1.setLoanType(loan.getLoanType());
         loan1.setId(loanid);
         //loan1.setUserid(loan.getUserid());
         loan1.setSalary(loan.getSalary());
         loan1.setAmount_needed(loan.getAmount_needed());
         loan1.setSpan(loan.getSpan());
         loan1.setEmi(loan.getEmi());
         loan1.setStatus(loan.getStatus());
         
        return loanRepo.save(loan1) ;
        
    }
    public void deleteById(int a)
    {
    	loanRepo.deleteById(a);
    }
 

}