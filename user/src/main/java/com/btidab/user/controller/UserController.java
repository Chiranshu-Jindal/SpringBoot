package com.btidab.user.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.btidab.user.model.StatModel;
import com.btidab.user.model.UserModel;
import com.btidab.user.service.StatService;
import com.btidab.user.service.UserService;

@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;

	@Autowired
	private StatService statservice;

	@GetMapping("/users")
	public List<UserModel> getAllUser() {
		logger.trace("entering getalluser() method");
		logger.info("getalluser executed successfully");
		return service.getalluser();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<?> getById(@PathVariable long id) { // here i use ? to handle multipleResponses(usermodel and
																// error)
		logger.trace("entering getbyid() method");
		Optional<UserModel> u = service.getbyid(id);
		if (u.isPresent()) {
			logger.info("fetching the user data of ID: {}", id);
			return ResponseEntity.ok(u.get());
		} else {
			logger.warn("user is not found with Id: {}", id);
			return ResponseEntity.status(400).body("user not found");
		}
	}

	@PostMapping("/users")
	public ResponseEntity<UserModel> insertdata(@RequestBody UserModel user) {
		logger.trace("entering insertdata() method");
		try {
			UserModel createuser = service.createuser(user);
			logger.info("user created successfully with Id: {}", createuser.getId());
			return ResponseEntity.ok(createuser);
		} catch (Exception e) {
			logger.error("error occurred while creating user", e);
			return ResponseEntity.status(500).body(null);
		}
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteuser(@PathVariable Long id) {
		logger.trace("entering deleteuser() method");
		try {
			service.deleteuser(id);
			logger.info("user successfully deleted");
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			logger.error("error occured while deleting user");
			return ResponseEntity.status(500).build();
		}
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<UserModel> updateuser(@PathVariable Long id, @RequestBody UserModel data) {
		logger.trace("entering updateuser() method");
		try {
			UserModel updateduser = service.updateuser(id, data);
			logger.info("user updated successfully");
			return ResponseEntity.ok(updateduser);
		} catch (RuntimeException e) {
			logger.warn("user not found with Id: {}", id);
			return ResponseEntity.status(404).build();
		} catch (Exception e) {
			logger.error("error occured while updating the user");
			return ResponseEntity.status(500).body(null);
		}
	}

	@GetMapping("/users/stats")
	public ResponseEntity<StatModel> getstat() {
		logger.trace("entering getstats() method");
		logger.info("successfully fetched stats data");
		return ResponseEntity.ok(statservice.getstats());
	}
}
//return service.getbyid();
