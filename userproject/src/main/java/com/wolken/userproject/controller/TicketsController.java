package com.wolken.userproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.userproject.dto.TicketsDTO;
import com.wolken.userproject.service.TicketsService;

@RestController
public class TicketsController {
	private Logger logger=LoggerFactory.getLogger(TicketsController.class);
	@Autowired
	TicketsService service;
	
	@PostMapping("AddTickets")
	String save(@RequestBody TicketsDTO dto)
	{
		String msg=null;
		try {
			logger.info(""+dto);
			msg=service.validateAndAdd(dto);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
		}
	     return msg;
	}
	
	@GetMapping("getUserTickets")
	TicketsDTO getUserTickets(@Param(value="ticketeName")String ticketeName)
		{
		TicketsDTO dto = null;

			try {
				logger.info(ticketeName);
				dto = service.validateAndFindByUserTickets(ticketeName);
			} catch (Exception e) {
				logger.error("========you have an exception  ===");
				logger.error(e.getMessage(), e.getClass());

			}
			return dto;
		}
	
	@PostMapping("updateTickets")
	String updateTickets(@RequestBody TicketsDTO dto) {
		String msg=null;
		try {
			logger.info(""+dto);
			msg=service.validateAndUpdateTickets(dto);
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			}
		
		return msg;
		
	}
	@GetMapping("getAllTickets")
	List<TicketsDTO> getAll() {
		List<TicketsDTO> dto = null;
		try {
		
			dto=service.validateAndGetAllTickets();
		} catch (Exception e) {
			logger.error("=============== you have an exception  =====");
			logger.error(e.getMessage(), e.getClass());
		}
		
		return dto;
	}
}

