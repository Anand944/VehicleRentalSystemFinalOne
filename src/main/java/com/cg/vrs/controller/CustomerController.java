package com.cg.vrs.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import com.cg.vrs.entities.Customer;
import com.cg.vrs.exception.RecordNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.vrs.exception.RecordNotFoundException;
import com.cg.vrs.service.ICustomerService;
import com.cg.vrs.utility.GlobalResources;

@RestController
@RequestMapping("/vrs-customer")
public class CustomerController {
	@Autowired
	ICustomerService iCustomerService;
	private Logger logger = GlobalResources.getLogger(CustomerController.class);
	
	@PostMapping("/addcustomer")
	public String addCustomer(@Valid@RequestBody Customer customer) throws RecordNotFoundException{
		String methodName = "addCustomer()";
		logger.info(methodName + "Called");
		return iCustomerService.addCustomer(customer);
	}
	
	@DeleteMapping("/removecustomer/{id}")
	public String removeCustomer(@PathVariable("id")int customerid) throws RecordNotFoundException{
		String methodName = "removeCustomer()";
		logger.info(methodName + "Called");
		return iCustomerService.removeCustomer(customerid);
	}
	
	@GetMapping("/getcustomer/{id}")
	public Customer viewCustomer(@PathVariable("id")int customerid) throws RecordNotFoundException{
		String methodName = "viewCustomer()";
		logger.info(methodName + "Called");
		return iCustomerService.viewCustomer(customerid);
	}
	
	@PutMapping("/updatecustomer")
	public String updateCustomer(@Valid @RequestBody Customer c) throws RecordNotFoundException{
		String methodName = "updateCustomer()";
		logger.info(methodName + "Called");
		return iCustomerService.updateCustomer(c);
	}
	
	@GetMapping("/getallcustomer/{vtype}")
	public List<Customer> viewAllCustomer(@PathVariable("vtype") String vtype) throws RecordNotFoundException{
		String methodName = "viewAllCustomer()";
		logger.info(methodName + "Called");
		return iCustomerService.viewAllCustomer(vtype);
	}
	
	 @GetMapping("/getallbyLocation/{location}")
		List<Customer> getCustomerByLocation(@PathVariable("location") String location) throws RecordNotFoundException
		{
		 String methodName = "getCustomerByLocation()";
			logger.info(methodName + "Called");
		return iCustomerService. viewAllCustomersByLocation(location);
		}
	   

}
