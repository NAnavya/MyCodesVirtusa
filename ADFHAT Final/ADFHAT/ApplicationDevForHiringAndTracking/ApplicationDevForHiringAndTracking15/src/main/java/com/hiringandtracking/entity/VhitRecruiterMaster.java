package com.hiringandtracking.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class VhitRecruiterMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long vrmId;

    @NotBlank(message = "EMPLOYEEID cannot be Null or Empty")
    private int vrmEmployeeId;

    @Email
    @Pattern(regexp = "(a-zA-Z)*\\@virtusa\\.com")
    @NotBlank(message = "EMPLOYEE_MAIL cannot be Null or Empty")
    private  String vrmMail;

    @NotBlank(message = "EMPLOYEENAME cannot be Null or Empty")
    private String vrmName;

    @NotBlank(message = "DESIGNATION_LOOKUP cannot be Null or Empty")
    @ManyToOne
    private VhitLookupCodes vrmDesignationLookUp;

}
