package com.cg.vrs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int userId;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	private String role;
	
	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
	private Customer customer;

	public User(int userId, String username, String password, String role, Customer customer) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.customer = customer;
	}

	
}