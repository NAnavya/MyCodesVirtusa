package com.virtusa.topupLoansSpring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

 

@Entity
@Table(name = "images")
public class Document{

 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 

    @Lob
    @Column(nullable = false)
    private byte[] imageData;

 

    // Getters and setters
    // ...
}
