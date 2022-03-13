package com.cg.vrs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.vrs.entities.Driver;


@Repository("dr")
public interface DriverRepository extends JpaRepository<Driver,Integer>{

}
