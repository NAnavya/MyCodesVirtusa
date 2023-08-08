package com.vir.online_banking_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vir.online_banking_app.dto.TransactionDto;
import com.vir.online_banking_app.model.Transaction;
import com.vir.online_banking_app.service.TransactionService;

@CrossOrigin("*")
@RequestMapping("/transaction")
@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PostMapping("/addTransaction")
	public ResponseEntity<Transaction> addUser(@RequestBody TransactionDto transactiondto) {
		return ResponseEntity.ok(transactionService.addTransaction(transactiondto));
	}

	@DeleteMapping("/deleteTransaction/{id}")
	public ResponseEntity<String> deleteTransaction(@PathVariable long id) {
		this.transactionService.deleteTransaction(id);
		return ResponseEntity.ok("Transaction successfully deleted");
	}

	@GetMapping("/getTransaction/{id}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable long id) {
		return ResponseEntity.ok(this.transactionService.getTransaction(id));
	}
}
