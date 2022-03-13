package com.cg.vrs.service;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cg.vrs.dao.IBookingRepository;
import com.cg.vrs.dao.ICustomerRepository;
import com.cg.vrs.entities.Booking;
import com.cg.vrs.entities.Customer;
import com.cg.vrs.entities.Vehicle;
import com.cg.vrs.exception.RecordNotFoundException;

@Service("IBookingService")
public class IBookingServiceImpl implements IBookingService{
	
	@Autowired
	IBookingRepository iBookingRepository;
	
	@Autowired
	ICustomerRepository iCustomerRepository;

	@Override
	public ResponseEntity addBooking(Booking booking) throws RecordNotFoundException {
		iBookingRepository.saveAndFlush(booking);
		return new ResponseEntity("Booking added successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity cancelBooking(Booking b) throws RecordNotFoundException {
		Booking bean = null;
		try {
			bean = iBookingRepository.findById(b.getBookingId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("Booking details not found!");
		}
		iBookingRepository.deleteById(b.getBookingId());
		return new ResponseEntity("Booking deleted successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity updateBooking(Booking b) throws RecordNotFoundException {
		Booking bean = null;
		try {
			bean = iBookingRepository.findById(b.getBookingId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("Booking details not found!");
		}
		iBookingRepository.saveAndFlush(b);
		return new ResponseEntity("Booking updated successfully",HttpStatus.OK);
	}

	@Override
	public Booking viewBooking(int bid) throws RecordNotFoundException {
		Booking bean = null;
		try {
			bean = iBookingRepository.findById(bid).get();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("Booking details not found!");
		}
		return bean;
	}

	@Override
	public List<Booking> viewAllBooking(Customer customer) throws RecordNotFoundException {
		List<Booking> bookings = new ArrayList<Booking>();
		try {
			bookings = iCustomerRepository.findById(customer.getCustomerId()).get().getBookings();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("Bookings details not Found");
		}
		return bookings;
	}

	@Override
	public List<Booking> viewAllBookingByDate(LocalDate bookingDate) throws RecordNotFoundException {
		List<Booking> bookings = new ArrayList<Booking>();
		try {
			for(Booking i :iBookingRepository.findAll()) {
				if(i.getBookingDate()==bookingDate) {
					bookings.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFoundException("Bookings details not Found");
		}
		return bookings;
	}

	@Override
	public List<Booking> viewAllBookingByVehicle(Vehicle vehicle) throws RecordNotFoundException {
		List<Booking> bookings = new ArrayList<Booking>();
		try {
			bookings = iBookingRepository.findById(vehicle.getVehicleId()).get().getVehicle().getBookings();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("Bookings details not Found");
		}
		return bookings;
	}

}
