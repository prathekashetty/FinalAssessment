package com.wolken.userproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserandTicketsDTO {
	private int ticketeId;
	private int userId;
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
