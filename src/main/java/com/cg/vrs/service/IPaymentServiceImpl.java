package com.cg.vrs.service;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.vrs.dao.IPaymentRepository;
import com.cg.vrs.entities.Payment;
import com.cg.vrs.entities.Vehicle;
import com.cg.vrs.exception.RecordNotFoundException;

@Service("IPaymentService")
public class IPaymentServiceImpl implements IPaymentService {
	
	@Autowired
	IPaymentRepository iPaymentRepository;

	@Override
	public String addPayment(Payment payment) throws RecordNotFoundException {
		iPaymentRepository.save(payment);
		return "Payment added successfully";
	}

	@Override
	public String cancelPayment(Payment p) throws RecordNotFoundException {
		Payment bean = null;
		try {
			bean = iPaymentRepository.findById(p.getPaymentId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("Payment details not found!");
		}
		iPaymentRepository.deleteById(p.getPaymentId());
		return "Payment deleted successfully";
	}

	@Override
	public Payment viewPayment(int p) throws RecordNotFoundException {
		Payment bean = null;
		try {
			bean = iPaymentRepository.findById(p).get();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("Payment details not found!");
		}
		return bean;
	}

	@Override
	public List<Payment> viewAllPayments(Vehicle vehicle) throws RecordNotFoundException {
		List<Payment> payments = new ArrayList<Payment>();
		try {
			payments = vehicle.getPayments();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("Payment details not found!");
		}
		return payments;
	}

	@Override
	public double calculateMonthlyRevenue(LocalDate d1, LocalDate d2) throws RecordNotFoundException {
		List<Payment> temp = new ArrayList<Payment>();
		List<Payment> payments = iPaymentRepository.findAll();
		double ans = 0;
		try {
			for(int i = 0;i< payments.size();i++) {
				if(payments.get(i).getPaymentDate().isAfter(d1) && payments.get(i).getPaymentDate().isBefore(d2)) {
					ans+=payments.get(i).getVehicle().getFixedCharges();
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFoundException("Payment details not Found");
		}
		return ans;
	}

	@Override
	public double calculateTotalPayment(Vehicle v) throws RecordNotFoundException {
		List<Payment> temp = v.getPayments();
		double ans = 0;
		try {
			for(int i = 0;i< temp.size();i++) {
				ans+=temp.get(i).getVehicle().getFixedCharges();
			}
		}
		catch(Exception e) {
			throw new RecordNotFoundException("Payment details not Found");
		}
		return v.getFixedCharges();
	}
	
	

}
