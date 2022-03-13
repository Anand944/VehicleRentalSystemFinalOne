package com.cg.vrs.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.vrs.dao.IUserRepository;
import com.cg.vrs.entities.Customer;
import com.cg.vrs.entities.User;
import com.cg.vrs.exception.RecordNotFoundException;

class TestIUserService {

	@Mock
	IUserRepository ur;
	@InjectMocks
	IUserService us;
	User user; @BeforeEach
	public void testCommon() {
	// bsi=new IBookingServiceImpl();
	// br=Mockito.mock(BookingRepository.class);
	MockitoAnnotations.initMocks(this);
	Customer c = new Customer(111, "md", "adiyan", "7717733344", "adiayn@hmail.com",
	"bangalore", "twowheeler", null, null);
	User user= new User(101, "Adiyan", "adiyan321", "analyst", c); }

	@Test
	public void testaddUser() throws RecordNotFoundException {
	Mockito.when(ur.saveAndFlush(user)).thenReturn(user);
	//String actualResult=service.addPayment(b);
	ResponseEntity<User> expectedResult= new ResponseEntity("User added successfully!",HttpStatus.OK);
	assertEquals(expectedResult,us.addUser(user));
	Mockito.verify(ur,Mockito.times(1)).saveAndFlush(user);
	}
	@Test
	public void testvalidateUser() {
	Mockito.when(ur.findAll());
	//String actualResult=service.updatePayment(payment);
	ResponseEntity<User> expectedResult=new ResponseEntity("Authentication successfully done!",HttpStatus.OK);
	assertEquals(expectedResult,us);
	Mockito.verify(ur,Mockito.times(1)).findAll();
	}
	
	}




