package com.wolken.wolkenuser.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class TicketsDTO {
	 private int ticketeId;
	  private String ticketeName;
	  private String category;
	  private String createDate;
	  private String closeDate;
	  private String description;
	  private boolean status;
	  
	  
	  
	
}
