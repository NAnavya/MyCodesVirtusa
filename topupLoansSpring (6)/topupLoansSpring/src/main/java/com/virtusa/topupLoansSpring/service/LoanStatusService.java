package com.virtusa.topupLoansSpring.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.virtusa.topupLoansSpring.entities.LoanStatus;
import com.virtusa.topupLoansSpring.entities.UserProfile;
import com.virtusa.topupLoansSpring.exception.UserNotFoundException;
import com.virtusa.topupLoansSpring.repo.LoanStatusRepo;
import com.virtusa.topupLoansSpring.repo.UserProfileRepo;

 

@Service
public class LoanStatusService {
    @Autowired LoanStatusRepo loanStatusRepo;
    @Autowired UserProfileRepo userProfileRepo;

 

    public LoanStatus addLoanStatus(int userid, int loanid, LoanStatus loanStatus) {
        // TODO Auto-generated method stub
        UserProfile userProfile=new UserProfile();
        loanStatusRepo.save(loanStatus);
        userProfile=userProfileRepo.findById(userid).orElseThrow(()-> new UserNotFoundException("User Not Found exception"));
        
        userProfileRepo.save(userProfile);
        return loanStatus;
    }
    public List<LoanStatus> getApprovedLoans() {
        // TODO Auto-generated method stub
        return loanStatusRepo.findByStatus("Approved");
    }

    public List<LoanStatus> getNotApprovedLoans() {
        return loanStatusRepo.findByStatus("NotApproved");
    }

 

}