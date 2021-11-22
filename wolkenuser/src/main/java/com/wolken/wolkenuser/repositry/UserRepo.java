package com.wolken.wolkenuser.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.wolkenuser.entity.UserEntity;



public  interface UserRepo  extends JpaRepository<UserEntity, Integer> {

	UserEntity findByEmail(String email);
	 
}


