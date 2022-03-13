package com.cg.vrs.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@NotEmpty
	private String firstName;
	private String lastName;
	@NotEmpty
	private String mobileNumber;
	private String emailId;
	@NotEmpty
	private String address;
	private String vType;
	
	@OneToMany(mappedBy = "customer" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Booking> bookings;
	
	@OneToMany(mappedBy = "customer" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Payment> payments;

	public Customer(int customerId, String firstName, String lastName, String mobileNumber, String emailId,
			String address, String vType, List<Booking> bookings, List<Payment> payments) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.address = address;
		this.vType = vType;
		this.bookings = bookings;
		this.payments = payments;
	}
}
	