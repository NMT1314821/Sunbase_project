package com.springjwt.entities;

import org.hibernate.cfg.annotations.Nullability;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="customers")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	@NotEmpty(message="customer first_name mandatory")
	private String first_name;
	
	@Column(nullable = false)
	@NotEmpty(message="customer first_name mandatory")
	private String last_name;
	private String street;
	private String address;
	private String city;
	private String state;
	private String email;
	private String phone;
}
