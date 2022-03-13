package com.cg.vrs.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.vrs.entities.Booking;
import com.cg.vrs.entities.Customer;
import com.cg.vrs.entities.Vehicle;
import com.cg.vrs.exception.RecordNotFoundException;
import com.cg.vrs.service.IBookingService;
import com.cg.vrs.utility.GlobalResources;

@RestController
@RequestMapping("/vrs-booking")
public class BookingController {
	@Autowired
	IBookingService iBookingService;
	private Logger logger = GlobalResources.getLogger(BookingController.class);
	@PostMapping("/addbooking")
	public ResponseEntity addBooking(@Valid@RequestBody Booking booking) throws RecordNotFoundException{
		String methodName = "addBooking()";
		logger.info(methodName + "Called");
		return iBookingService.addBooking(booking);
	}

	@DeleteMapping("/cancelbooking")
	public ResponseEntity cancelBooking(@RequestBody Booking b) throws RecordNotFoundException{
		String methodName = "updateBooking()";
		logger.info(methodName + "Called");
		return iBookingService.cancelBooking(b);
	}

	@PutMapping("/updatebooking")
	public ResponseEntity updateBooking(@Valid@RequestBody Booking b) throws RecordNotFoundException{
		String methodName = "updateBooking()";
		logger.info(methodName + "Called");
		return iBookingService.updateBooking(b);
	}

	@GetMapping("/getbookingbyid/{bid}")
	public Booking viewBooking(@PathVariable int bid) throws RecordNotFoundException{
		String methodName = "viewBooking()";
		logger.info(methodName + "Called");
		return iBookingService.viewBooking(bid);
	}

	@GetMapping("/getallbooking")
	public List<Booking> viewAllBooking(@RequestBody Customer customer) throws RecordNotFoundException{
		String methodName = "viewAllBooking()";
		logger.info(methodName + "Called");
		return iBookingService.viewAllBooking(customer);
	}

	@GetMapping("/getbooking/{bookingDate}")
	public List<Booking> viewAllBookingByDate(@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate) throws RecordNotFoundException{
		String methodName = "viewAllBookingByDate()";
		logger.info(methodName + "Called");
		return iBookingService.viewAllBookingByDate(bookingDate);
	}

	@GetMapping("/getallbookingbyvehicle")
	public List<Booking> viewAllBookingByVehicle(@RequestBody Vehicle vehicle) throws RecordNotFoundException{
		String methodName = "viewAllBookingByDate()";
		logger.info(methodName + "Called");
		return iBookingService.viewAllBookingByVehicle(vehicle);
	}

}




