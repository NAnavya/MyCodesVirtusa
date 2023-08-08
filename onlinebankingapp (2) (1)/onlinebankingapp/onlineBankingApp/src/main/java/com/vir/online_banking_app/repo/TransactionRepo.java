package com.vir.online_banking_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vir.online_banking_app.dto.TransactionDto;
import com.vir.online_banking_app.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction,Long> {

	Transaction save(TransactionDto transaction);


}
