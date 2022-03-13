package com.cg.vrs.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String email;
	private String address;
	private double chargesPerDay;
	private String licenseNo;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "vehicle_drivers",
			joinColumns = {@JoinColumn(name = "driver_id", referencedColumnName = "driverId")},
			inverseJoinColumns = {@JoinColumn(name = "vehicle_id", referencedColumnName = "vehicleId")}
	)
	private List<Vehicle> vehicles;

	public Driver(int driverId, String firstName, String lastName, String contactNumber, String email, String address,
			double chargesPerDay, String licenseNo, List<Vehicle> vehicles) {
		super();
		this.driverId = driverId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.chargesPerDay = chargesPerDay;
		this.licenseNo = licenseNo;
		this.vehicles = vehicles;
	}

	
}