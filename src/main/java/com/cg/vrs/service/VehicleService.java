package com.cg.vrs.service;

import java.util.List;

import com.cg.vrs.entities.Vehicle;
import com.cg.vrs.exception.RecordNotFoundException;



public interface VehicleService {
	
	public String addVehicle(Vehicle vehicle);
	public List<Vehicle> getAllVehicle();
	public Vehicle getVehicleById(int vehicleId) throws RecordNotFoundException;
	public String deleteVehicleById(int vehicleId);
	
}
