package com.wolken.wolkenuser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenuser.dto.UserDTO;
import com.wolken.wolkenuser.service.UserService;




@RestController
public class UserController {
	private Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService service;
	
	@PostMapping("AddUser")
	String save(@RequestBody UserDTO dto)
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
	
	@GetMapping("getUser")
	UserDTO getByUser(@Param(value="email")String email)
		{
		UserDTO dto = null;

			try {
				logger.info(email);
				dto = service.validateAndFindByemail(email);
			} catch (Exception e) {
				logger.error("========you have an exception  ===");
				logger.error(e.getMessage(), e.getClass());

			}
			return dto;
		}
	@PostMapping("updateUser")
	String updateUser(@RequestBody UserDTO dto) {
		String msg=null;
		try {
			logger.info(""+dto);
			msg=service.validateAndUpdate(dto);
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			}
		
		return msg;
		
	}
	@GetMapping("getAllUser")
	List<UserDTO> getAll() {
		List<UserDTO> dto = null;
		try {
		
			dto=service.validateAndGetAllUser();
		} catch (Exception e) {
			logger.error("=============== you have an exception =====");
			logger.error(e.getMessage(), e.getClass());
		}
		
		return dto;
	}

	
}
 