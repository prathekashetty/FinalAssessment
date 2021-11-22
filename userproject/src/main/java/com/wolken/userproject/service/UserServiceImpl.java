package com.wolken.userproject.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.userproject.dto.UserDTO;
import com.wolken.userproject.entity.UserEntity;
import com.wolken.userproject.repositry.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo repo;
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserandTicketsService service;
	@Override
	public String validateAndAdd(UserDTO dto) {
		try {
			if (dto != null) {
				logger.info("" + dto);
				UserEntity entity = new UserEntity();
				BeanUtils.copyProperties(dto, entity);
				logger.info("" + entity);
				repo.save(entity);
				service.addToMap(dto);
				logger.info("User Login Successfully");
				return "User Login Successfully";
			}

		} catch (NullPointerException | TypeMismatchException e) {
			logger.error(e.getMessage(), e.getClass().getSimpleName());
		}
		return null;
	}

	@Override
	public UserDTO validateAndFindByemail(String email) {
		try {
			if (email != null) {
				logger.info(email);
				UserEntity entity = repo.findByEmail(email);
				logger.info("" + entity);
				if (entity != null) {
					UserDTO dto = new UserDTO();
					BeanUtils.copyProperties(entity, dto);
					return dto;
				}
			} else {
				logger.info("invalid email");
				return null;
			}
		} catch (Exception e) {
			logger.error("========you have an exception ===");
			logger.error(e.getMessage(), e.getClass());

			return null;
		}
		return null;

	}

	@Override
	public String validateAndUpdate(UserDTO dto) {

		UserEntity entity = new UserEntity();
		entity = repo.findByEmail(dto.getEmail());
		logger.info("entity"+entity);
		if (dto != null) {
			if (dto.getAddress() != null) {

				entity.setAddress(dto.getAddress());
			}
			if (dto.getAge() != 0) {
				entity.setAge(dto.getAge());
			}
			if (dto.getContactNumber() != 0) {
				entity.setContactNumber(dto.getContactNumber());
			}

			if (dto.getEmail() != null) {
				entity.setEmail(dto.getEmail());
			}
			if (dto.getFirstName() != null) {
				entity.setFirstName(dto.getFirstName());
			}
			if (dto.getLastName() != null) {
				entity.setLastName(dto.getLastName());
			}
			if (dto.getGender() != null) {
				entity.setGender(dto.getGender());
			}
			if (dto.getConfirmPassword() != null) {
				entity.setConfirmPassword(dto.getConfirmPassword());
			}
			if (dto.getPassword() != null) {
				entity.setPassword(dto.getPassword());
			}
			if (dto.getCountryCode() != 0) {
				entity.setCountryCode(dto.getCountryCode());
			}
			repo.save(entity);
			return "User Updated Sucessfully";
		}
		return null;

	}

	@Override
	public List<UserDTO> validateAndGetAllUser() {
		 
			List<UserDTO> dtos=new ArrayList();
			List<UserEntity> list=repo.findAll();
			logger.info("list"+list.toString());
			for(UserEntity userEntity : list) {
				UserDTO dto=new UserDTO();
				BeanUtils.copyProperties(userEntity, dto);
				dtos.add(dto);
				logger.info("dto"+dto);
			}
			return dtos;
		
	}
	
}
