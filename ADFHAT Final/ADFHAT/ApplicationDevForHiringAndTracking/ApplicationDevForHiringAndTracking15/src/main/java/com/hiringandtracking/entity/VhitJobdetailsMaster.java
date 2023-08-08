package com.hiringandtracking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "vhit_jobdetails")
public class VhitJobdetailsMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vjmId;

    @NotBlank(message = "Role_Name cannot be Null or Empty")
    private String vjmRoleName;

    @NotBlank(message = "CTC_Offered cannot be Null or Empty")
    private int vjmCTCOffered;

    @NotBlank(message = "Location cannot be Null or Empty")
    private String vjmLocation;
}