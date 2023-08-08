package com.vir.online_banking_app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vir.online_banking_app.dto.TransactionDto;
import com.vir.online_banking_app.exception.ResourceNotFoundException;
import com.vir.online_banking_app.model.Account;
import com.vir.online_banking_app.model.Transaction;
import com.vir.online_banking_app.repo.AccountRepo;
import com.vir.online_banking_app.repo.TransactionRepo;
import com.vir.online_banking_app.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepo transactionRepo;
	@Autowired
	AccountRepo accountRepo;

	@Override
	public Transaction addTransaction(TransactionDto transaction) {

		Account ts = accountRepo.findByAccNo(transaction.getToAcc());
		Account ts1 = accountRepo.findByAccNo(transaction.getFromAcc());
		if ((transaction.getAmount() > 0) && !(ts.equals(null)) && !(ts1.equals(null))) {
			accountRepo.withdrawAmountByAccountId(transaction.getFromAcc(), transaction.getAmount());
			accountRepo.debitAmountByAccountId(transaction.getToAcc(), transaction.getAmount());
		}
		return transactionRepo.save(transaction);

	}

	@Override
	public void deleteTransaction(long id) {
		this.transactionRepo.deleteById(id);

	}

	@Override
	public Transaction updateTransaction(long id, Transaction transaction) {
		return transactionRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));
	}

	@Override
	public Transaction getTransaction(long id) {

		return this.transactionRepo.findById(id).orElseThrow();
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return this.transactionRepo.findAll();

	}
}
