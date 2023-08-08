package com.hiringandtracking.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class VhitLookupCodeValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lookUpValueId;

    @OneToOne
    @JoinColumn(name = "LOOKUP_CODE_ID")
    @NotBlank(message = "CODE_ID cannot be Null or Empty")
    private VhitLookupCodes lookUpCodeId;

    @NotBlank(message = "VALUES cannot be Null or Empty")
    private String lookUpValue;

    @NotBlank(message = "DESC cannot be Null or Empty")
    private String lookUpDesc;
}
