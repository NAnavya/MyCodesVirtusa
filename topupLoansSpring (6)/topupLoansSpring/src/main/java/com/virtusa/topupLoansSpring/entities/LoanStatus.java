package com.virtusa.topupLoansSpring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

 

import org.springframework.beans.factory.annotation.Value;

 

@Entity
public class LoanStatus {
     @Id
     private int userid;
    @NotNull
    private int loanid;
    //@Column(columnDefinition="VARCHAR(20) DEFAULT 'PROCESSING'")
    @NotBlank
    @Value("PENDING")
    private String status;
    @NotNull
    private String EMI;
    private String interest;
    public LoanStatus() {
        super();
        // TODO Auto-generated constructor stub
    }
    public LoanStatus(int userid, int loanid, String status, String eMI, String interest) {
        super();
        this.userid = userid;
        this.loanid = loanid;
        this.status = status;
        EMI = eMI;
        this.interest = interest;
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public int getLoanid() {
        return loanid;
    }
    public void setLoanid(int loanid) {
        this.loanid = loanid;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getEMI() {
        return EMI;
    }
    public void setEMI(String eMI) {
        EMI = eMI;
    }
    public String getInterest() {
        return interest;
    }
    public void setInterest(String interest) {
        this.interest = interest;
    }
    @Override
    public String toString() {
        return "LoanStatus [userid=" + userid + ", loanid=" + loanid + ", status=" + status + ", EMI=" + EMI
                + ", interest=" + interest + "]";
    }

}
