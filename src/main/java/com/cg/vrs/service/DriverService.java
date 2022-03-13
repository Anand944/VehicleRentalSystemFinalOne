package com.cg.vrs.service;

import java.util.List;

import com.cg.vrs.entities.Driver;
import com.cg.vrs.exception.RecordNotFoundException;

public interface DriverService {

		public String addDriver(Driver driver);
		public List<Driver> getAllDriver();
		public String deleteDriverById(int DriverId);
		public Driver getDriverById(int DriverId) throws RecordNotFoundException;
		public String updateDriver(Driver driver);



}
