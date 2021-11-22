package com.wolken.wolkenuser.service;

import java.util.List;

import com.wolken.wolkenuser.dto.UserDTO;

public interface UserService {

	String validateAndAdd(UserDTO dto);

	UserDTO validateAndFindByemail(String email);

	String validateAndUpdate(UserDTO dto);

	List<UserDTO> validateAndGetAllUser();

	

}
