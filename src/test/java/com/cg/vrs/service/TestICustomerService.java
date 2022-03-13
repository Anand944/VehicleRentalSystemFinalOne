package com.cg.vrs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.vrs.dao.ICustomerRepository;
import com.cg.vrs.entities.Booking;
import com.cg.vrs.entities.Customer;
import com.cg.vrs.entities.Driver;
import com.cg.vrs.entities.Payment;
import com.cg.vrs.exception.RecordNotFoundException;

class TestICustomerService {

	@Mock
	ICustomerRepository  cr;
	@InjectMocks
	ICustomerServiceImpl cs;
	Customer customer;
	private List<Payment> listp;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		Driver driver=new Driver(133, "buu", "ygyh", "798788787", "bvhhbhb@gmail.com", "huhgsbhg", 222.6, "787",null);
		List<Booking> listb=new ArrayList<>();
		listb.add(new Booking(111, customer, null, LocalDate.of(2022, 03, 10), LocalDate.of(2022, 03, 11), "bbbbbbbbb", 1500.00, 525.5));
		Booking b=new Booking(102 ,customer, null, LocalDate.of(2022, 03, 10), LocalDate.of(2022, 03, 11), "bbbbbbbbb", 1500.00, 525.5);
		List<Payment> listp=new ArrayList<>();
		listp.add(new Payment(1,"online",LocalDate.of(2022, 03, 10) , b, customer,null, "complrted"));
		customer=new Customer(101,"Anand", "kumbaji", "929298279", "siddu@gmail","hyd","2wheel",listb,listp);
	}

	@Test
	public void testAddCustomer() throws RecordNotFoundException {
		Mockito.when(cr.save(customer)).thenReturn(customer);
		String expectedResult="Customer added successfully";
		assertEquals(expectedResult,cs.addCustomer(customer));
		Mockito.verify(cr,Mockito.times(1)).save(customer);

	}
	@Test
	public void testViewCustomer() throws RecordNotFoundException {
		int id=101;
		Mockito.when(cr.findById(id)).thenReturn(Optional.of(customer));
		Customer actualResult=cs.viewCustomer(id);
		assertEquals(actualResult.getCustomerId(),customer.getCustomerId());
		Mockito.verify(cr,Mockito.times(1)).findById(id);
	}
	@Test
	public void testViewCustomerFailure() {
		int id=-101;
		Mockito.when(cr.findById(id)).thenReturn(Optional.empty());
		assertThrows( RecordNotFoundException.class,()->cs.viewCustomer(id));
		Mockito.verify(cr,Mockito.times(1)).findById(id);
	}

	@Test
	public void testRemoveCustomer() throws RecordNotFoundException {
		int id= 101;

		Mockito.when(cr.findById(id)).thenReturn(Optional.of(customer));

		String expectedResult= (" Customer Deleted Successfully for this Id:"+" "+id);
		assertEquals(expectedResult,cs.removeCustomer(id));
		Mockito.verify(cr,Mockito.times(1)).findById(id);
	}
	@Test
	public void testRemoveCustomerFailure() {
		int id= -13;
		Mockito.when(cr.findById(id)).thenReturn(Optional.empty());
		assertThrows(RecordNotFoundException.class,()->cs.removeCustomer(id));
		Mockito.verify(cr,Mockito.times(1)).findById(id);
	}
	
	
	@Test
	public void testUpdateCustomer() throws RecordNotFoundException {
		Mockito.when(cr.save(customer)).thenReturn(customer);
		String expectedResult="Updated Successfully!!!";
		assertEquals(expectedResult,cs.updateCustomer(customer));
		Mockito.verify(cr,Mockito.times(1)).save(customer);
	}
	
}
