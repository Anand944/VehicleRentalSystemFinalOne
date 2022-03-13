package com.cg.vrs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.vrs.dao.VehicleRepository;
import com.cg.vrs.entities.Vehicle;
import com.cg.vrs.exception.RecordNotFoundException;


class TestVehicleService {

	@Mock
	VehicleRepository vr;
	@InjectMocks
	VehicleServiceImpl vsi;
	Vehicle v;
	
	@BeforeEach
	public void testCommon() {
		MockitoAnnotations.initMocks(this);
		v=new Vehicle(1, "BG543","4Wheeler","Car","Good","HYd","10", 100, 150, null, null, null);
	}
	
	@Test
	public void testAddVehicle() {
		Mockito.when(vr.save(v)).thenReturn(v);
		String expectedResult="Vehicle is Added";
		assertEquals(expectedResult,vsi.addVehicle(v));
		Mockito.verify(vr,Mockito.times(1)).save(v);	
		
	}
	@Test
	void testGetVehicleById() throws RecordNotFoundException {
		int id=1;
		Mockito.when(vr.findById(id)).thenReturn(Optional.of(v));
		Vehicle actualResult=vsi.getVehicleById(id);
		assertEquals(actualResult.getVehicleId(),v.getVehicleId());
		Mockito.verify(vr,Mockito.times(1)).findById(id);
			
	}
	@Test
	void testgetVehicleByIdFailure() {
		int id=-101;
		Mockito.when(vr.findById(id)).thenReturn(Optional.empty());
		assertThrows(RecordNotFoundException.class,()->vsi.getVehicleById(id));
		Mockito.verify(vr,Mockito.times(1)).findById(id);
		
	}

}
