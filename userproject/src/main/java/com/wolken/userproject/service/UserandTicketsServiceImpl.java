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
import com.wolken.userproject.dto.UserandTicketsDTO;
import com.wolken.userproject.entity.TicketsEntity;
import com.wolken.userproject.entity.UserEntity;
import com.wolken.userproject.entity.UserandTicketsEntity;
import com.wolken.userproject.repositry.UserandTicketsRepo;

@Service
public class UserandTicketsServiceImpl implements UserandTicketsService {
	@Autowired
	UserandTicketsRepo userandTicketRepository;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserandTicketsEntity addToMap(UserDTO dto) {
		// TODO Auto-generated method stub
		UserandTicketsEntity entity = new UserandTicketsEntity();
		BeanUtils.copyProperties(dto, entity);
		userandTicketRepository.save(entity);
		return null;
	}

	@Override
	public void addTicketToMap(TicketsEntity entity) {
		// TODO Auto-generated method stub
		
		UserandTicketsEntity mentity = new UserandTicketsEntity();
		mentity = userandTicketRepository.findByUserId(entity.getUser_id());
		mentity.setTicketeId(entity.getTicketeId());
		mentity.setDescription(entity.getDescription());
		mentity.setCategory(entity.getCategory());
		mentity.setCloseDate(entity.getCloseDate());
		mentity.setCreateDate(entity.getCreateDate());
		mentity.setTicketeName(entity.getTicketeName());
		mentity.setStatus(entity.isStatus());
		userandTicketRepository.save(mentity);
	}

	public String mappingUserandTicket(UserEntity userEntity, TicketsEntity ticketEntity) {
		try {
			UserandTicketsEntity userandTicketEntity = new UserandTicketsEntity();
			BeanUtils.copyProperties(ticketEntity, userandTicketEntity);
			BeanUtils.copyProperties(userEntity, userandTicketEntity);
			userandTicketRepository.save(userandTicketEntity);
			logger.info("" + userandTicketEntity);
			logger.info("maping saved");
		} catch (NullPointerException | TypeMismatchException e) {
			logger.error(e.getMessage(), e.getClass().getSimpleName());
		}

		return "saved";
	}

	@Override
	public String updateMapping(TicketsEntity ticketEntity) {
		UserandTicketsEntity userandTicketEntity = userandTicketRepository.findByTicketeId(ticketEntity.getTicketeId());
		try {
			if (userandTicketEntity != null) {
				BeanUtils.copyProperties(ticketEntity, userandTicketEntity);
				userandTicketRepository.save(userandTicketEntity);
				logger.info("" + userandTicketEntity);
				logger.info("maping saved");
				return "saved";
			}
		} catch (NullPointerException | TypeMismatchException e) {
			logger.error(e.getMessage(), e.getClass().getSimpleName());
		}

		return null;

	}

	@Override
	public List<UserandTicketsEntity> updateUserMapping(UserEntity userEntity) {
		List<UserandTicketsEntity> userandTicketEntity = userandTicketRepository.findById(userEntity.getUser_id());
		List<UserandTicketsEntity> userandTicketEntities = new ArrayList<>();
		try {
			if (userandTicketEntity != null) {
				logger.info("a" + userEntity);
				for (UserandTicketsEntity userandTicketEntity2 : userandTicketEntity) {
					BeanUtils.copyProperties(userEntity, userandTicketEntity2);
					logger.info("" + userandTicketEntity2);
					userandTicketEntities.add(userandTicketEntity2);
					logger.info("" + userandTicketEntities + "\n");
					logger.info("maping saved");
				}
				userandTicketRepository.saveAll(userandTicketEntities);
				logger.info("" + userandTicketEntities);
			}
		} catch (NullPointerException | TypeMismatchException e) {
			logger.error(e.getMessage(), e.getClass().getSimpleName());
		}
		return userandTicketEntity;
	}

	@Override
	public List<UserandTicketsDTO> getAllTicket() {
		List<UserandTicketsDTO> userandTicketDTOs = new ArrayList<>();

		try {
			List<UserandTicketsEntity> userandTicketEntities = userandTicketRepository.findAll();
			
			for (UserandTicketsEntity userandTicketEntity : userandTicketEntities) {
				UserandTicketsDTO userandTicketDTO = new UserandTicketsDTO();
				BeanUtils.copyProperties(userandTicketEntity, userandTicketDTO);
				userandTicketDTOs.add(userandTicketDTO);
			}
		} catch (NullPointerException | TypeMismatchException e) {
			logger.error(e.getMessage(), e.getClass().getName());
		}
		return userandTicketDTOs;
	}

	@Override
	public List<UserandTicketsDTO> getUserTicket(int id) {
		List<UserandTicketsDTO> userandTicketDTOs = new ArrayList<>();

		try {
			List<UserandTicketsEntity> userandTicketEntities = userandTicketRepository.findById(id);
			UserandTicketsDTO userandTicketDTO = new UserandTicketsDTO();
			for (UserandTicketsEntity userandTicketEntity : userandTicketEntities) {
				BeanUtils.copyProperties(userandTicketEntity, userandTicketDTO);
				userandTicketDTOs.add(userandTicketDTO);
			}
		} catch (NullPointerException | TypeMismatchException e) {
			logger.error(e.getMessage(), e.getClass().getName());
		}
		return userandTicketDTOs;
	}

	

}
