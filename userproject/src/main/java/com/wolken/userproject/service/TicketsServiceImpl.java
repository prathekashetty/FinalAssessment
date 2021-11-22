package com.wolken.userproject.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.userproject.dto.TicketsDTO;
import com.wolken.userproject.entity.TicketsEntity;
import com.wolken.userproject.repositry.TicketsRepo;

@Service
public class TicketsServiceImpl implements TicketsService {
	@Autowired
	TicketsRepo repo;
	private Logger logger=LoggerFactory.getLogger(TicketsServiceImpl.class);
	@Autowired
	UserandTicketsService service;
	
	@Override
	public String validateAndAdd(TicketsDTO dto) {
		try {
			if(dto!=null)
			{
				logger.info(""+dto);
				TicketsEntity entity=new TicketsEntity();
				BeanUtils.copyProperties(dto, entity);
				logger.info(""+entity);
				repo.save(entity);
				service.addTicketToMap(entity);
				logger.info("Added Tickets");
				return "Added Tickets";
			}
			
		}catch(NullPointerException | TypeMismatchException e)
		{
		  logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
		return null;
	}



	@Override
	public TicketsDTO validateAndFindByUserTickets(String ticketeName) {
		try {
			if (ticketeName != null) {
				logger.info(ticketeName);
				TicketsEntity entity = repo.findByTicketeName(ticketeName);
				logger.info("" + entity);
				if (entity != null) {
					TicketsDTO dto = new TicketsDTO();
					BeanUtils.copyProperties(entity, dto);
					return dto;
				}
			} else {
				logger.info("invalid ticketeName");
				return null;
			}
		} catch (Exception e) {
			logger.error("========you have an exception in ===");
			logger.error(e.getMessage(), e.getClass());

			return null;
		}
		return null;

	}


	@Override
	public String validateAndUpdateTickets(TicketsDTO dto) {
		TicketsEntity entity = new TicketsEntity();
		entity = repo.findByTicketeName(dto.getTicketeName());
		logger.info("entity"+entity);
		if (dto != null) {
			if (dto.getTicketeName() != null) {

				entity.setTicketeName(dto.getTicketeName());
			}
			
			if (dto.getCategory() != null) {
				entity.setCategory(dto.getCategory());
			}
			if (dto.getCreateDate() != null) {
				entity.setCreateDate(dto.getCreateDate());
			}
			if (dto.getCloseDate() != null) {
				entity.setCloseDate(dto.getCloseDate());
			}
			if (dto.getDescription() != null) {
				entity.setDescription(dto.getDescription());
			}
			if (dto.isStatus() == false) {
				entity.setStatus(dto.isStatus());
			}
			
			repo.save(entity);
			return "Ticketes Updated Sucessfully";
		}
		return null;

	
	}



	@Override
	public List<TicketsDTO> validateAndGetAllTickets() {
		List<TicketsDTO> dtos=new ArrayList();
		List<TicketsEntity> list=repo.findAll();
		logger.info("list"+list.toString());
		for(TicketsEntity ticketsEntity : list) {
			TicketsDTO dto=new TicketsDTO();
			BeanUtils.copyProperties(ticketsEntity, dto);
			dtos.add(dto);
			logger.info("dto"+dto);
		}
		return dtos;
	
}

}
