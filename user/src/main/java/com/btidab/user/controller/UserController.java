package com.btidab.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.btidab.user.entity.User;
import com.btidab.user.model.UserModel;
import com.btidab.user.service.UserService;

@RestController
public class UserController {
	List<User> users = new ArrayList<>();
	@Autowired
	private UserService service;

	@GetMapping("/users")
	public List<UserModel> getAllUser() {
		return service.getalluser();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserModel> getById(@PathVariable long id) {
		Optional<UserModel> u = service.getbyid(id);
		if (u.isPresent()) {
			return ResponseEntity.ok(u.get());
		} else {
			return null;
		}
	}

	@PostMapping("/users")
	public UserModel insertdata(@RequestBody UserModel user) {
		return service.createuser(user);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteuser(@PathVariable Long id) {
		service.deleteuser(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<UserModel> updateuser(@PathVariable Long id, @RequestBody UserModel data) {
		UserModel updateduser = service.updateuser(id, data);
		return ResponseEntity.ok(updateduser);
	}

}
//return service.getbyid();
