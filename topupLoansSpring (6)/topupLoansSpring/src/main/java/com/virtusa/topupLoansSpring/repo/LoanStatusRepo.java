package com.virtusa.topupLoansSpring.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import com.virtusa.topupLoansSpring.entities.LoanStatus;

 

public interface LoanStatusRepo extends JpaRepository<LoanStatus,Integer> {

 

    List<LoanStatus> findByStatus(String status);
}
