package com.cg.vrs.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.cg.vrs.entities.Customer;
import com.cg.vrs.exception.RecordNotFoundException;

public interface ICustomerService {

	public String addCustomer(Customer customer) throws RecordNotFoundException;
	public String removeCustomer(int customerid) throws RecordNotFoundException;
	public Customer viewCustomer(int customerid) throws RecordNotFoundException;
	public String updateCustomer(Customer c) throws RecordNotFoundException;
	public List<Customer> viewAllCustomer(String vtype) throws RecordNotFoundException;
	public List<Customer> viewAllCustomersByLocation(String location)throws RecordNotFoundException;
	
}
