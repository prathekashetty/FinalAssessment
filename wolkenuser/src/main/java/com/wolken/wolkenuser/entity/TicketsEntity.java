package com.wolken.wolkenuser.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table
@Entity
@NoArgsConstructor
public class TicketsEntity {
	@GenericGenerator(name="Pratheeka", strategy ="increment")
	@GeneratedValue(generator="Pratheeka")
	@Id
  private int tickete_id;
  private String ticketeName;
  private String category;
  private String createDate;
  private String closeDate;
  private String description;
  private boolean status;
  
  
  
}
