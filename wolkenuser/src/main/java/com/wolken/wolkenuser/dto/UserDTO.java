package com.wolken.wolkenuser.dto;

import java.util.List;

import com.wolken.wolkenuser.entity.TicketsEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO {
	
	private String firstName;
	private String lastName;
	private  long contactNumber;
	private String gender;
	private int age;
	private String email;
	private String password;
	private String confirmPassword;
	private String address;
	private long countryCode;
	private List<TicketsEntity> ticket;
}
