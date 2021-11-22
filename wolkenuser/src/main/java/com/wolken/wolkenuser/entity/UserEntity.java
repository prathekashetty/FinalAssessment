package com.wolken.wolkenuser.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table
@Entity
public class UserEntity {
	@GenericGenerator(name="Pratheeka", strategy ="increment")
	@GeneratedValue(generator="Pratheeka")
	@Id
	private int user_id;
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
	
	@OneToMany(targetEntity=TicketsEntity.class,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName="user_id")
	private List<TicketsEntity> ticket;
	
	
}
