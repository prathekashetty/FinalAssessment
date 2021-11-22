package com.wolken.userproject.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.userproject.entity.TicketsEntity;



public  interface TicketsRepo  extends JpaRepository<TicketsEntity, Integer> {

	TicketsEntity findByTicketeName(String ticketeName);
	 
}
