package com.cg.vrs.service;
import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.vrs.dao.ICustomerRepository;
import com.cg.vrs.entities.Customer;
import com.cg.vrs.exception.RecordNotFoundException;

@Service("ICustomerService")
public class ICustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICustomerRepository iCustomerRepository;

	@Override
	public  String addCustomer(Customer customer) throws RecordNotFoundException {
		iCustomerRepository.save(customer);
		 return "Customer added successfully";
	}

	@Override
	public String removeCustomer(int customerid) throws RecordNotFoundException {
		Optional<Customer> op=iCustomerRepository.findById(customerid);
		if(op.isPresent()) {
		iCustomerRepository.deleteById(customerid);
		return (" Customer Deleted Successfully for this Id:"+" "+customerid);
		}else
		throw new RecordNotFoundException("Customer not found Plz Check customerid:" +customerid);
	}

	@Override
	public Customer viewCustomer(int customerid) throws RecordNotFoundException {
		Customer bean = null;
		try {
			bean = iCustomerRepository.findById(customerid).get();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("Customer details not found!");
		}
		return bean;
	}

	@Override
	public String updateCustomer(Customer c) throws RecordNotFoundException {
		Customer customerUpdated=iCustomerRepository.save(c);
		if(customerUpdated != null)
		return "Updated Successfully!!!";
		else
		return "There is proble in updation";
	}

	@Override
	public List<Customer> viewAllCustomer(String vtype) throws RecordNotFoundException {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			for(Customer i :iCustomerRepository.findAll()) {
				if(i.getVType().equals(vtype)) {
					customers.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFoundException("Customers details not Found");
		}
		return customers;
	}

	@Override
	public List<Customer> viewAllCustomersByLocation(String location) throws RecordNotFoundException {
			List<Customer> customers = new ArrayList<Customer>();
			try {
				for(Customer i :iCustomerRepository.findAll()) {
					if(i.getAddress().equals(location)) {
						customers.add(i);
					}
				}
			}
			catch(Exception e) {
				throw new RecordNotFoundException("Customers details not Found");
			}
			return customers;
		}

}
