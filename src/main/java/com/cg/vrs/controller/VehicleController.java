package com.cg.vrs.controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.vrs.entities.Vehicle;
import com.cg.vrs.exception.RecordNotFoundException;
import com.cg.vrs.service.VehicleService;
import com.cg.vrs.utility.GlobalResources;

@RestController
@RequestMapping("/Vehicles")
public class VehicleController {

	@Autowired
	private VehicleService vs;
	private Logger logger = GlobalResources.getLogger(VehicleController.class);

	@PostMapping("/addvehicles")
	String addVehicle(@Valid@RequestBody Vehicle vehicle) {
		String methodName = "addVehicle()";
		logger.info(methodName + "Called");
		return vs.addVehicle(vehicle);
	}

	@GetMapping("/vehicles")
	List<Vehicle> getAllVehicle()
	{
		String methodName = "getAllVehicle()";
		logger.info(methodName + "Called");
		return vs.getAllVehicle();
	}

	@GetMapping("/vehicles/id/{id}")
	Vehicle getVehicleById(@PathVariable("id") int vehicleId) throws RecordNotFoundException
	{
		String methodName = "getVehicleById()";
		logger.info(methodName + "Called");
		return vs.getVehicleById(vehicleId);
	}

	@DeleteMapping("/vehiclesBy/{id}")
	String deleteByVehicleId(@PathVariable("id") int vehicleId) {
		String methodName = "deleteByVehicleId()";
		logger.info(methodName + "Called");
		return vs.deleteVehicleById(vehicleId);
	}



}
