package com.wolken.wolkenuser.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.wolkenuser.entity.TicketsEntity;



public  interface TicketsRepo  extends JpaRepository<TicketsEntity, Integer> {

	TicketsEntity findByTicketeName(String ticketeName);
	 
}
