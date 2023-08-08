package com.vir.online_banking_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vir.online_banking_app.model.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Account a set a.bal=a.bal-?2 where a.accNo=?1 ")
	public void withdrawAmountByAccountId(long l, float f);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Account  set bal=bal+?2 where accNo=?1 ")
	public void debitAmountByAccountId(long l, float f);

	public Account findByAccNo(long accNo);
}