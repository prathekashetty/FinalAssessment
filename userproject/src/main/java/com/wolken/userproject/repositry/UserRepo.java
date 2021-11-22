package com.wolken.userproject.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.userproject.entity.UserEntity;



public  interface UserRepo  extends JpaRepository<UserEntity, Integer> {

	UserEntity findByEmail(String email);
	 
}


