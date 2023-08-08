package com.hiringandtracking.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
public class VhitLookupCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lookUpId;

    @NotBlank(message = "BLOCK cannot be Null or Empty")
    private String lookUpBlock;

    @NotBlank(message = "CODE cannot be Null or Empty")
    private String lookUpCode;

}
