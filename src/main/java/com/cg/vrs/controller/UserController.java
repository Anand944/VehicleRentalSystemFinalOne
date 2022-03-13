package com.cg.vrs.controller;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.cg.vrs.entities.User;
import com.cg.vrs.exception.RecordNotFoundException;
import com.cg.vrs.service.IUserService;
import com.cg.vrs.utility.GlobalResources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.vrs.exception.RecordNotFoundException;

@RestController
@RequestMapping("/vrs-user")
public class UserController {
	private Logger logger = GlobalResources.getLogger(UserController.class);
	@Autowired
	IUserService iUserService;
	
	@GetMapping("/validate")
	public ResponseEntity validateUser(@Valid@RequestBody User user) throws RecordNotFoundException{
		String methodName = "validateUser()";
		logger.info(methodName + "Called");
		return iUserService.validateUser(user);
	}
	
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) throws RecordNotFoundException{
	BCryptPasswordEncoder becrypt=new BCryptPasswordEncoder();
	String encodePwd = becrypt.encode(user.getPassword());
	user.setPassword(encodePwd);
	String methodName = "addUser()";
	logger.info(methodName + "Called");
	return iUserService.addUser(user);
	}
	
	@DeleteMapping("/removeuser")
	public ResponseEntity removeUser(@RequestBody User user) throws RecordNotFoundException{
		String methodName = "removeUser()";
		logger.info(methodName + "Called");
		return iUserService.removeUser(user);
	}
	
	@GetMapping("/signout")
	public ResponseEntity signOut(@RequestBody User user) throws RecordNotFoundException{
		String methodName = "signOut()";
		logger.info(methodName + "Called");
		return iUserService.signOut(user);
	}

}
