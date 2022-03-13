package com.cg.vrs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.vrs.entities.Payment;


@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer>{
	
}


