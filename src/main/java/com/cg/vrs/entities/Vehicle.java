package com.cg.vrs.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int vehicleId;
	
	private String vehicleNumber;
	private String type;//car//bus
	private String category ; //ac or nonac
	private String description;
	private String location;
	private String capacity;
	private double chargesPerKM;
	private double fixedCharges;
	
	@OneToMany(mappedBy = "vehicle" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Booking> bookings;
	
	@OneToMany(mappedBy = "vehicle" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Payment> payments;
	
	@ManyToMany(mappedBy = "vehicles")
	private List<Driver> drivers;

	public Vehicle(int vehicleId, String vehicleNumber, String type, String category, String description,
			String location, String capacity, double chargesPerKM, double fixedCharges, List<Booking> bookings,
			List<Payment> payments, List<Driver> drivers) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.location = location;
		this.capacity = capacity;
		this.chargesPerKM = chargesPerKM;
		this.fixedCharges = fixedCharges;
		this.bookings = bookings;
		this.payments = payments;
		this.drivers = drivers;
	}

}