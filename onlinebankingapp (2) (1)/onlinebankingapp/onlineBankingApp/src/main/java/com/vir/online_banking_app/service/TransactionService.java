package com.vir.online_banking_app.service;

import java.util.List;

import com.vir.online_banking_app.dto.TransactionDto;
import com.vir.online_banking_app.model.Transaction;

public interface TransactionService {


	public Transaction addTransaction(TransactionDto transactiondto);
	public void deleteTransaction(long id);
	public Transaction updateTransaction(long id,Transaction transaction);
	public Transaction getTransaction(long id);
	public List<Transaction> getAllTransactions();
	
}
