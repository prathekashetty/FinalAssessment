package com.wolken.userproject.service;

import java.util.List;

import com.wolken.userproject.dto.UserDTO;

public interface UserService {

	String validateAndAdd(UserDTO dto);

	UserDTO validateAndFindByemail(String email);

	String validateAndUpdate(UserDTO dto);

	List<UserDTO> validateAndGetAllUser();

	

}
