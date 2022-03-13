package com.cg.vrs.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vrs.dao.VehicleRepository;
import com.cg.vrs.entities.Vehicle;
import com.cg.vrs.exception.RecordNotFoundException;


@Service("vs")
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleRepository vr;
	
	@Override
	public String addVehicle(Vehicle vehicle) {
		vr.save(vehicle);
		return "Vehicle is Added";
		
	}
	
	@Override
	public List <Vehicle> getAllVehicle(){
		return vr.findAll();
		
	}
	@Override
	public Vehicle getVehicleById(int vehicleId) throws RecordNotFoundException {

			Optional<Vehicle> op=vr.findById(vehicleId);
			if(op.isPresent())
				return op.get();
			else
				throw new RecordNotFoundException("Vehicle not found for this id "+vehicleId);
		
	}
	
	@Override
	public String deleteVehicleById(int vehicleId) {
		vr.deleteById(vehicleId);
		return "Deleted Successfully";
		
	}

	

}
