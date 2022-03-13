package com.cg.vrs.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.vrs.dao.IUserRepository;
import com.cg.vrs.entities.User;
import com.cg.vrs.exception.RecordNotFoundException;

@Service("IUserService")
public class IUserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepository iUserRepository;

	@Override
	public ResponseEntity validateUser(User user) throws RecordNotFoundException {
		try {
			for(User i : iUserRepository.findAll()) {
				if(user.getUsername().equals(i.getUsername())) {
					if(user.getPassword().equals(i.getPassword())) {
						return new ResponseEntity("Authentication successfully done!",HttpStatus.OK);
					}
					return new ResponseEntity("Authentication Failed, Check username and password",HttpStatus.NOT_FOUND);
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFoundException("User details not found! Invalid details");
		}
		return new ResponseEntity("Authentication successfully done!",HttpStatus.OK);
	}

	@Override
	public User addUser(User user) throws RecordNotFoundException {
		User bean =iUserRepository.saveAndFlush(user);
		return bean;
	}

	@Override
	public ResponseEntity removeUser(User user) throws RecordNotFoundException {
		User bean = null;
		try {
			bean = iUserRepository.findById(user.getUserId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFoundException("User details not found!");
		}
		iUserRepository.deleteById(user.getUserId());
		return new ResponseEntity("User deleted successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity signOut(User user) throws RecordNotFoundException {
		try {
			if(validateUser(user).equals("Authentication successfully done!") && validateUser(user).getStatusCodeValue()==200) {
				return new ResponseEntity("Signed Out successfully",HttpStatus.OK);
			}
			else {
				return new ResponseEntity("Invalid Privilege",HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity("Signed Out successfully",HttpStatus.OK);
	}

}
