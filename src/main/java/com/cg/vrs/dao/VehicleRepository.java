package com.cg.vrs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vrs.entities.Vehicle;



@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
	
	

}
