package com.cg.vrs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.vrs.dao.DriverRepository;
import com.cg.vrs.entities.Driver;
import com.cg.vrs.exception.RecordNotFoundException;

class TestDriverService {

	@Mock
	DriverRepository dr;
	@InjectMocks
	DriverServiceImpl ds;
	Driver driver;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		 driver=new Driver(1, "buu", "ygyh", "798788787", "bvhhbhb@gmail.com", "huhgsbhg", 222.6, "787",null);
	}

	@Test
	public void testAddDriver() {
		Mockito.when(dr.save(driver)).thenReturn(driver);
		String expectedResult="Driver is Added";
		assertEquals(expectedResult,ds.addDriver(driver));
		Mockito.verify(dr,Mockito.times(1)).save(driver);

	}
	@Test
	public void testgetDriverByIdFailure() {
		int id=-101;
		Mockito.when(dr.findById(id)).thenReturn(Optional.empty());
		assertThrows(RecordNotFoundException.class,()->ds.getDriverById(id));
		Mockito.verify(dr,Mockito.times(1)).findById(id);
	}

}
