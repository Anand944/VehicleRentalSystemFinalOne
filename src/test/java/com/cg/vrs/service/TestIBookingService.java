package com.cg.vrs.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


	
	import static org.junit.jupiter.api.Assertions.*;



	import java.time.LocalDate;
	import java.util.ArrayList;
	import java.util.Optional;



	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.MockitoAnnotations;
	import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.vrs.dao.IBookingRepository;
import com.cg.vrs.entities.Booking;
import com.cg.vrs.entities.Customer;
import com.cg.vrs.entities.Driver;
import com.cg.vrs.entities.Vehicle;
import com.cg.vrs.exception.RecordNotFoundException;




	@ExtendWith(MockitoExtension.class)
	class TestIBookingService {
	@Mock
	IBookingRepository br;
	@InjectMocks
	IBookingServiceImpl service;
	Booking b;
	Customer c;
	Driver d;
	Vehicle v;



	@BeforeEach
	public void testCommon() {
	// bsi=new IBookingServiceImpl();
	// br=Mockito.mock(BookingRepository.class);
	MockitoAnnotations.initMocks(this);
	Customer c = new Customer(121, "fttf", "cvg", "8788878786", "hgjbjnnjn@gmail.com", "hhbhbh", null, null, null);
	Driver d = new Driver(133, "buu", "ygyh", "798788787", "bvhhbhb@gmail.com", "huhgsbhg", 222.6, "787", null);
	//Vehicle v = new Vehicle(676, d, "KA 7889", "carr", "4wheel", "descriptiom", "karnataka", "5member", 12.5, 15.0);
	b = new Booking(111, c, null, LocalDate.of(2022, 03, 10), LocalDate.of(2022, 03, 11), "bbbbbbbbb", 1500.00, 525.5);



	}



	@Test
	public void testAddBooking() throws RecordNotFoundException {
	Mockito.when(br.saveAndFlush(b)).thenReturn(b);
	// String actualResult=service.addPayment(b);
	ResponseEntity expectedResult = new ResponseEntity("User added successfully!",HttpStatus.OK);
	assertEquals(expectedResult, service.addBooking(b));
	Mockito.verify(br, Mockito.times(1)).saveAndFlush(b);
	}



	@Test
	public void testUpdatePayment() throws RecordNotFoundException {
	Mockito.when(br.save(b)).thenReturn(b);
	// String actualResult=service.updatePayment(payment);
	String expectedResult = "Updated Successfully";
	assertEquals(expectedResult, service.updateBooking(b));
	Mockito.verify(br, Mockito.times(1)).save(b);
	}



	/*@Test
	public void testCancelBooking() {
	int id = 1;
	Mockito.when(br.deleteById(id)).thenReturn(Optional.of(b));
	String expectedResult = "Deleted Successfully";
	assertEquals(expectedResult, service.cancelBooking(id));
	// assertThrows(IdNotFoundException.class, ()->service.removePayment(id));
	Mockito.verify(br, Mockito.times(1)).deleteById(id);
	}*/







	}


