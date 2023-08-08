package com.virtusa.topupLoansSpring.repo;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.topupLoansSpring.entities.Loan;


public interface LoanRepo extends CrudRepository<Loan,Integer>{
	@Query(value="select * from Loan where user_id = ?1",nativeQuery =true)
	List<Loan> findByUserId(Integer userid);
	
	@Query(value="select id from Loan where user_id=?1",nativeQuery=true)
	int getidbyuid(int uid);
	
	@Transactional
    @Modifying
	@Query(value="DELETE FROM Loan WHERE user_id=?1",nativeQuery=true)
	public void deleteByuserId(int uid);
	
	@Transactional
    @Modifying
	@Query(value="DELETE FROM Loan WHERE id=?1",nativeQuery=true)
	public void deleteById(int id);
}