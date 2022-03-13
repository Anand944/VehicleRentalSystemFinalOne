package com.cg.vrs.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vrs.entities.Driver;
import com.cg.vrs.exception.RecordNotFoundException;
import com.cg.vrs.service.DriverService;
import com.cg.vrs.utility.GlobalResources;

@RestController
@RequestMapping("/Driver")
public class DriverController {
	@Autowired
	private DriverService ds;
	private Logger logger = GlobalResources.getLogger(BookingController.class);

	@PostMapping("/addDriver")
	public String addDriver(@Valid@RequestBody Driver driver) {
		String methodName = "addDriver()";
		logger.info(methodName + "Called");
		return ds.addDriver(driver);

	} @GetMapping("/Driver")
	public List<Driver> getAllDriver()
	{
		String methodName = "getAllDriver()";
		logger.info(methodName + "Called");
		return ds.getAllDriver();
	}

	@GetMapping("/Driver/{id}")
	public	Driver getDriverById(@PathVariable("id") int DriverId) throws RecordNotFoundException
	{
		String methodName = "getDriverById()";
		logger.info(methodName + "Called");
		return ds.getDriverById(DriverId);
	}

	@DeleteMapping("/Driver/{id}")
	public String deletevById(@PathVariable("id") int Driverid) {
		String methodName = "deletevById()";
		logger.info(methodName + "Called");
		return ds.deleteDriverById(Driverid);
	}
	@PostMapping("/updateDriver")
	public 	String updateDriver(@RequestBody Driver driver) {
		String methodName = "updateDriver()";
		logger.info(methodName + "Called");
		return ds.addDriver(driver);

	}

}