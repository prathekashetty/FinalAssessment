package com.wolken.userproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.userproject.dto.UserandTicketsDTO;
import com.wolken.userproject.service.UserandTicketsService;

@RestController
public class UserandTicketsController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserandTicketsService userandTicketService;
	
	@GetMapping("alltickets")
	List<UserandTicketsDTO> alltickets(){
		List<UserandTicketsDTO> userandTicketDTOs=null;
		try {
			userandTicketDTOs = userandTicketService.getAllTicket();
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
		return userandTicketDTOs;
	}
	
	@GetMapping("usertickets")
	List<UserandTicketsDTO> usertickets(@RequestParam int id){
		List<UserandTicketsDTO> userandTicketDTOs=null;
		try {
			userandTicketDTOs = userandTicketService.getUserTicket(id);
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
		return userandTicketDTOs;
	}
	
}

