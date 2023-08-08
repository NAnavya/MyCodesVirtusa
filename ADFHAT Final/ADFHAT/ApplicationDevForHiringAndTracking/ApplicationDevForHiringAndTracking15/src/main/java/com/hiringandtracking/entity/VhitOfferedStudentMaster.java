package com.hiringandtracking.entity;


import com.hiringandtracking.enums.Branch;
import com.hiringandtracking.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.sql.Date;

@Data
@Entity
@Table(name = "VHIT_OFFERED_STUDENT_MASTER")
public class VhitOfferedStudentMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vosId;

    @NotBlank(message = "FirstName cannot be Null or Empty")
    private String vosFirstName;

    @NotBlank(message = "LastName cannot be Null or Empty")
    private String vosLastName;

    @Email(message = "clg email should be a email")
    private String vosCollegeMail;

    @Email(message = "Per email should be a email")
   // @NotBlank(message = "FirstName cannot be Null or Empty")
    private String vosPersonalMail;

    @NotBlank(message = "AADHARNO cannot be Null or Empty")
//    @Max(12)
    private String vosAadhaarNo;

//    @NotBlank(message = "GENDER cannot be Null or Empty")
    @Enumerated(EnumType.STRING)
    private Gender vosGender;

//    @NotBlank(message = "BRANCH cannot be Null or Empty")
    @Enumerated(EnumType.STRING)
    private Branch vosBranch;

//    @NotBlank(message = "DOB cannot be Null or Empty")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date vosDOB;

    @NotBlank(message = "MOBILENUMBER cannot be Null or Empty")
    private String vosMobileNo;

//    @NotBlank(message = "OFFERED_DATE cannot be Null or Empty")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date vosOfferedDate;


//    @NotBlank(message = "FINANCIAL_YEAR_ONBOARDING cannot be Null or Empty")
//    @Max(4)
    private int vosFinancialYearOnboarding;

    //TO BE CLARIFIED
    @NotBlank(message = "HIREDTHROUGH cannot be Null or Empty")
    private String vosHiredThrough;


//    @NotBlank(message = "COLLEGE_MASTER cannot be Null or Empty")
    @ManyToOne
    @JoinColumn(name = "VOS_COLLEGE_MASTER")
    private VhitCollegeMaster vosCollegeMaster;


//    @NotBlank(message = "DEGREE_LOOKUP_MASTER cannot be Null or Empty")
    @ManyToOne
    @JoinColumn(name = "VOS_DEGREE_LOOKUP_MASTER")
    private VhitLookupCodes vosDegreeLookupMaster;


//    @NotBlank(message = "RECRUITER_MASTER cannot be Null or Empty")
    @ManyToOne
    @JoinColumn(name = "VOS_RECRUITER_MASTER")
    private VhitRecruiterMaster vosRecruiterMaster;

//    @NotBlank(message = "JOBDETAILS_MASTER cannot be Null or Empty")
    @ManyToOne
    @JoinColumn(name = "VOS_JOBDETAILS_MASTER")
    private VhitJobdetailsMaster vosJobDetails;

//    @NotBlank(message = "TECHSTACK_LOOKUP_CODE cannot be Null or Empty")
    @ManyToOne
    private VhitLookupCodes vmcTechStackLookUpCode;

	public Long getVosId() {
		return vosId;
	}

	public void setVosId(Long vosId) {
		this.vosId = vosId;
	}

	public String getVosFirstName() {
		return vosFirstName;
	}

	public void setVosFirstName(String vosFirstName) {
		this.vosFirstName = vosFirstName;
	}

	public String getVosLastName() {
		return vosLastName;
	}

	public void setVosLastName(String vosLastName) {
		this.vosLastName = vosLastName;
	}

	public String getVosCollegeMail() {
		return vosCollegeMail;
	}

	public void setVosCollegeMail(String vosCollegeMail) {
		this.vosCollegeMail = vosCollegeMail;
	}

	public String getVosPersonalMail() {
		return vosPersonalMail;
	}

	public void setVosPersonalMail(String vosPersonalMail) {
		this.vosPersonalMail = vosPersonalMail;
	}

	public String getVosAadhaarNo() {
		return vosAadhaarNo;
	}

	public void setVosAadhaarNo(String vosAadhaarNo) {
		this.vosAadhaarNo = vosAadhaarNo;
	}

	public Gender getVosGender() {
		return vosGender;
	}

	public void setVosGender(Gender vosGender) {
		this.vosGender = vosGender;
	}

	public Branch getVosBranch() {
		return vosBranch;
	}

	public void setVosBranch(Branch vosBranch) {
		this.vosBranch = vosBranch;
	}

	public Date getVosDOB() {
		return vosDOB;
	}

	public void setVosDOB(Date vosDOB) {
		this.vosDOB = vosDOB;
	}

	public String getVosMobileNo() {
		return vosMobileNo;
	}

	public void setVosMobileNo(String vosMobileNo) {
		this.vosMobileNo = vosMobileNo;
	}

	public Date getVosOfferedDate() {
		return vosOfferedDate;
	}

	public void setVosOfferedDate(Date vosOfferedDate) {
		this.vosOfferedDate = vosOfferedDate;
	}

	public int getVosFinancialYearOnboarding() {
		return vosFinancialYearOnboarding;
	}

	public void setVosFinancialYearOnboarding(int vosFinancialYearOnboarding) {
		this.vosFinancialYearOnboarding = vosFinancialYearOnboarding;
	}

	public String getVosHiredThrough() {
		return vosHiredThrough;
	}

	public void setVosHiredThrough(String vosHiredThrough) {
		this.vosHiredThrough = vosHiredThrough;
	}

	public VhitCollegeMaster getVosCollegeMaster() {
		return vosCollegeMaster;
	}

	public void setVosCollegeMaster(VhitCollegeMaster vosCollegeMaster) {
		this.vosCollegeMaster = vosCollegeMaster;
	}

	public VhitLookupCodes getVosDegreeLookupMaster() {
		return vosDegreeLookupMaster;
	}

	public void setVosDegreeLookupMaster(VhitLookupCodes vosDegreeLookupMaster) {
		this.vosDegreeLookupMaster = vosDegreeLookupMaster;
	}

	public VhitRecruiterMaster getVosRecruiterMaster() {
		return vosRecruiterMaster;
	}

	public void setVosRecruiterMaster(VhitRecruiterMaster vosRecruiterMaster) {
		this.vosRecruiterMaster = vosRecruiterMaster;
	}

	public VhitJobdetailsMaster getVosJobDetails() {
		return vosJobDetails;
	}

	public void setVosJobDetails(VhitJobdetailsMaster vosJobDetails) {
		this.vosJobDetails = vosJobDetails;
	}

	public VhitLookupCodes getVmcTechStackLookUpCode() {
		return vmcTechStackLookUpCode;
	}

	public void setVmcTechStackLookUpCode(VhitLookupCodes vmcTechStackLookUpCode) {
		this.vmcTechStackLookUpCode = vmcTechStackLookUpCode;
	}
    

}

