package com.cg.vrs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.vrs.entities.Customer;



@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

}
