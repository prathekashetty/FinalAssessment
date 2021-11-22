package com.wolken.userproject.service;

import java.util.List;

import com.wolken.userproject.dto.TicketsDTO;

public interface TicketsService {

	String validateAndAdd(TicketsDTO dto);

	TicketsDTO validateAndFindByUserTickets(String ticketeName);

	String validateAndUpdateTickets(TicketsDTO dto);

	List<TicketsDTO> validateAndGetAllTickets();

}
