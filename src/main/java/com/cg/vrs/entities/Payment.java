package com.cg.vrs.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	@NotEmpty
	private String paymentMode;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;
	
	@OneToOne
	@JoinColumn(name = "booking_id", referencedColumnName = "bookingId")
	private Booking booking;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "vehicle_id", referencedColumnName = "vehicleId")
	private Vehicle vehicle;
	@NotEmpty
	private String paymentStatus;

	public Payment(int paymentId, String paymentMode, LocalDate paymentDate, Booking booking, Customer customer,
			Vehicle vehicle, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
		this.booking = booking;
		this.customer = customer;
		this.vehicle = vehicle;
		this.paymentStatus = paymentStatus;
	}

}