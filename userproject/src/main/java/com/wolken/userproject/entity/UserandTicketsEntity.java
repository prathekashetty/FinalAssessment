package com.wolken.userproject.entity;

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
@Entity
@Table
@NoArgsConstructor
@ToString
public class UserandTicketsEntity {
	@Id
	@GenericGenerator(name="Pratheeka", strategy ="increment")
	@GeneratedValue(generator="Pratheeka")
	private int userId;
	private int ticketeId;
	private String firstName;
	private String lastName;
	private long contactNumber;
	private String gender;
	private int age;
	private String email;
	private String password;
	private String confirmPassword;
	private String address;
	private long countryCode;
	private String ticketeName;
	private String category;
	private String createDate;
	private String closeDate;
	private String description;
	private boolean status;
}
