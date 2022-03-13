package com.cg.vrs.service;

import org.springframework.http.ResponseEntity;

import com.cg.vrs.entities.User;
import com.cg.vrs.exception.RecordNotFoundException;

public interface IUserService {

	public ResponseEntity validateUser(User user) throws RecordNotFoundException;
	public User addUser(User user) throws RecordNotFoundException;
	public ResponseEntity removeUser(User user) throws RecordNotFoundException;
	public ResponseEntity signOut(User user) throws RecordNotFoundException;
}
