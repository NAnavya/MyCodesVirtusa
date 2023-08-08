package com.vir.online_banking_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vir.online_banking_app.model.User;

public interface UserRepo  extends JpaRepository<User,Long>{

}
