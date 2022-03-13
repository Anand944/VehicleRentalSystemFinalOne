package com.cg.vrs.service;

import java.time.LocalDate;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.vrs.entities.Payment;
import com.cg.vrs.entities.Vehicle;
import com.cg.vrs.exception.RecordNotFoundException;

public interface IPaymentService {

	public String addPayment(Payment payment) throws RecordNotFoundException;
	public String cancelPayment(Payment p) throws RecordNotFoundException;
	public Payment viewPayment(int p) throws RecordNotFoundException;
	public List<Payment> viewAllPayments(Vehicle vehicle) throws RecordNotFoundException;
	public double calculateMonthlyRevenue(LocalDate d1,LocalDate d2) throws RecordNotFoundException;
	public double calculateTotalPayment(Vehicle v) throws RecordNotFoundException;
	
}
