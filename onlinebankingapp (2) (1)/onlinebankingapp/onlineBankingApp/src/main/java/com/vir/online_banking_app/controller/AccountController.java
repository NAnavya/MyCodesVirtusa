package com.vir.online_banking_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vir.online_banking_app.dto.AccountDto;
import com.vir.online_banking_app.model.Account;
import com.vir.online_banking_app.repo.AccountRepo;
import com.vir.online_banking_app.service.AccountService;

@CrossOrigin("*")
@RequestMapping("/account")
@RestController
public class AccountController {
	@Autowired
	AccountRepo accRepo;

	@Autowired
	AccountService accountService;

	@PostMapping("/addAccount")
	public ResponseEntity<Account> addAccount(@RequestBody AccountDto accountDto) {
		System.out.println("hey");
		return ResponseEntity.ok(accountService.addAccount(accountDto));
	}

	@GetMapping("/getAccount")
	public ResponseEntity<Account> getAccount(@RequestParam long aid) {
		return ResponseEntity.ok(accountService.getAccount(aid));
	}

	@GetMapping("/getAllAccounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		return ResponseEntity.ok(accountService.getAllAccounts());
	}

	@PutMapping("/updateAccount")
	public ResponseEntity<Account> updateAccount(@RequestParam long aid, @RequestBody AccountDto accountdto) {
		return ResponseEntity.ok(accountService.updateAccount(aid, accountdto));
	}

	@GetMapping("/getAccount{accNo}")
	public ResponseEntity<Account> getByAccountNo(@PathVariable long accNo) {
		return ResponseEntity.ok(accountService.getBYAccNo(accNo));
	}

	@DeleteMapping("/deleteAccount/{id}")
	public ResponseEntity<String> deleteByAccountNo(@PathVariable long id) {
		accRepo.deleteById(id);
		return ResponseEntity.ok("Deleted Successfully");
	}

}
