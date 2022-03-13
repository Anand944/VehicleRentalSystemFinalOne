package com.cg.vrs.service;

import java.time.LocalDate;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.vrs.entities.Booking;
import com.cg.vrs.entities.Customer;
import com.cg.vrs.entities.Vehicle;
import com.cg.vrs.exception.RecordNotFoundException;



public interface IBookingService {

	public ResponseEntity addBooking(Booking booking) throws RecordNotFoundException;
	public ResponseEntity cancelBooking(Booking b) throws RecordNotFoundException;
	public ResponseEntity updateBooking(Booking b) throws RecordNotFoundException;
	public Booking viewBooking(int bid) throws RecordNotFoundException;
	public List<Booking> viewAllBooking(Customer customer) throws RecordNotFoundException;
	public List<Booking> viewAllBookingByDate(LocalDate bookingDate) throws RecordNotFoundException;
	public List<Booking> viewAllBookingByVehicle(Vehicle vehicle) throws RecordNotFoundException;

}
