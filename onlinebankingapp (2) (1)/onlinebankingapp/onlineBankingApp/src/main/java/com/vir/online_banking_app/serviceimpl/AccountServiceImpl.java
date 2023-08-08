package com.vir.online_banking_app.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vir.online_banking_app.dto.AccountDto;
import com.vir.online_banking_app.exception.ResourceNotFoundException;
import com.vir.online_banking_app.model.Account;
import com.vir.online_banking_app.repo.AccountRepo;
import com.vir.online_banking_app.repo.UserRepo;
import com.vir.online_banking_app.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepo accountRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	ModelMapper mp = new ModelMapper();

	@Override
	public Account addAccount(AccountDto accountDto) {
		Account ac = new Account();
		ac.setAccNo(accountDto.getAccNo());
		ac.setAccType(accountDto.getAccType());
		ac.setBal(accountDto.getBal());
		ac.setUser(userRepo.findById((long) accountDto.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found Exception")));
		return accountRepo.save(ac);
	}

	@Override
	public void deleteAccount(long id) {
		accountRepo.deleteById(id);

	}

	@Override
	public Account updateAccount(long id, AccountDto accountdto) {
		Account acc = mp.map(accountdto, Account.class);
		accountRepo.save(acc);
		return acc;

	}

	@Override
	public Account getAccount(long id) {
		return this.accountRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Account Not Found"));
	}

	@Override
	public Account getBYAccNo(long acNo) {

		return this.accountRepo.findByAccNo(acNo);
	}

	@Override
	public List<Account> getAllAccounts() {
		return this.accountRepo.findAll();
	}

}
