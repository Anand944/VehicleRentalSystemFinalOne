package com.cg.vrs.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vrs.dao.DriverRepository;
import com.cg.vrs.entities.Driver;
import com.cg.vrs.exception.RecordNotFoundException;

@Service("ds")
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	DriverRepository dr;
	
	@Override
	public String addDriver(Driver driver) {
	dr.save(driver);
	return "Driver is Added";
	}
	@Override
	public List <Driver> getAllDriver(){
	return dr.findAll();
	}
	@Override
	public Driver getDriverById(int DriverId) throws RecordNotFoundException {
	Optional<Driver> op=dr.findById(DriverId);
	if(op.isPresent())
	return op.get();
	else
	throw new RecordNotFoundException("Driver not found for this id "+DriverId);
	}
	@Override
	public String deleteDriverById(int DriverId) {
	dr.deleteById(DriverId);
	return "Deleted Successfully";
	}
	@Override
	public String updateDriver(Driver driver) {
		dr.save(driver);
		return "Update Successfully";
	}
	
}




