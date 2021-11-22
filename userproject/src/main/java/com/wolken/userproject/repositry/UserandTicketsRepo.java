package com.wolken.userproject.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.wolken.userproject.entity.UserandTicketsEntity;

public interface UserandTicketsRepo extends JpaRepositoryImplementation<UserandTicketsEntity, Integer>  
	 {
		
	UserandTicketsEntity findByTicketeId(int ticketeId);
		List<UserandTicketsEntity> findById(int id);
		UserandTicketsEntity findByUserId(int user_id);
		

	}

