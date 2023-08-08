package com.vir.online_banking_app.service;

import java.util.List;

import com.vir.online_banking_app.dto.AccountDto;
import com.vir.online_banking_app.model.Account;

public interface AccountService {

	public void deleteAccount(long id);
	public Account updateAccount(long id,AccountDto accountdto);
	public Account getAccount(long id);
	public List<Account> getAllAccounts();
	public Account addAccount(AccountDto accountDto);
	public Account getBYAccNo(long acNo);
	
}
