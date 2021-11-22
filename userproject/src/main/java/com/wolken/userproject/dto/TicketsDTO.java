package com.wolken.userproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

public class TicketsDTO {

	  private String ticketeName;
	  private String category;
	  private String createDate;
	  private String closeDate;
	  private String description;
	  private boolean status;
	  private int user_id;
	  
	  
	
}
