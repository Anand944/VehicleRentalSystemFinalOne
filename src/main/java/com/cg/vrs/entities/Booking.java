package com.cg.vrs.entities;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "vehicle_id", referencedColumnName = "vehicleId")
	private Vehicle vehicle;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") 
	private LocalDate bookingDate;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bookedTillDate;
	
	private String bookingDescription;
	private double totalCost;
	private double distance;
	
	public Booking(int bookingId, Customer customer, Vehicle vehicle, LocalDate bookingDate, LocalDate bookedTillDate,
			String bookingDescription, double totalCost, double distance) {
		super();
		this.bookingId = bookingId;
		this.customer = customer;
		this.vehicle = vehicle;
		this.bookingDate = bookingDate;
		this.bookedTillDate = bookedTillDate;
		this.bookingDescription = bookingDescription;
		this.totalCost = totalCost;
		this.distance = distance;
	}

	
	 
}



