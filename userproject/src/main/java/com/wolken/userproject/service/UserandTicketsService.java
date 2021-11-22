package com.wolken.userproject.service;

import java.util.List;

import com.wolken.userproject.dto.UserDTO;
import com.wolken.userproject.dto.UserandTicketsDTO;
import com.wolken.userproject.entity.TicketsEntity;
import com.wolken.userproject.entity.UserEntity;
import com.wolken.userproject.entity.UserandTicketsEntity;

public interface UserandTicketsService {
	String mappingUserandTicket(UserEntity userEntity,TicketsEntity ticketEntity);
	List<UserandTicketsDTO> getAllTicket();

	List<UserandTicketsDTO> getUserTicket(int id);

	
	UserandTicketsEntity addToMap(UserDTO dto);
	
	String updateMapping(TicketsEntity ticketEntity);
	List<UserandTicketsEntity> updateUserMapping(UserEntity userEntity);
	void addTicketToMap(TicketsEntity entity);

}
