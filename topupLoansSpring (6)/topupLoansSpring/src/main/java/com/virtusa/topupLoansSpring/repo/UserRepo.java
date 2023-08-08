package com.virtusa.topupLoansSpring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import com.virtusa.topupLoansSpring.entities.User;
import com.virtusa.topupLoansSpring.entities.UserProfile;

//${SPRING_SECURITY_LAST_EXCEPTION.message}
//spring.security.user.name=user
//spring.security.user.password=1234

public interface UserRepo extends JpaRepository<User,Integer> {

 

//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query("update Accounts set balance = balance-?2 where acctID=?1")
//    public void withdrawAmountByAcctID(int acctID, int balance);
    @Transactional
    @Modifying(clearAutomatically=true)
    @Query("update User set name=?2 where id=?1")
    public void updateNameById(int id,String name); 
    
    @Query(value="select * from User where email = ?1",nativeQuery =true)
    User findByEmail(String email);
    
    @Query("select password from User where email=?1")
    String findPassbyEmail(String email);
    
    @Query("select id from User where email=?1")
    int findidbyEmail(String email);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM User WHERE email=?1")
    public void deleteByEmail(String email);
    
    @Query("select id from User Where email=?1")
    int getidByEmail(String email);
     
    @Query("select role from User Where email=?1")
    String getRoleByemail(String email);
    
    @Query("select name from User Where email=?1")
    String findnamebyEmail(String email);
    
   

}
