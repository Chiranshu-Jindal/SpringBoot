package com.btidab.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

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
import com.btidab.user.entity.stat;
import com.btidab.user.model.UserModel;
import com.btidab.user.service.UserService;

@RestController
public class UserController {
//	private AtomicInteger getallusernumber = new AtomicInteger();
//	private AtomicInteger getbyidnumber = new AtomicInteger();;
//	private AtomicInteger insertdatanumber = new AtomicInteger();;
//	private AtomicInteger deletenumber = new AtomicInteger();;
//	private AtomicInteger updatenumber = new AtomicInteger();;

	private int getallusernumber = 0;
	private int getbyidnumber = 0;
	private int insertdatanumber = 0;
	private int deletenumber = 0;
	private int updatenumber = 0;

	List<User> users = new ArrayList<>();
	@Autowired
	private UserService service;

	@GetMapping("/users")
	public List<UserModel> getAllUser() {
//		getallusernumber.incrementAndGet();
		getallusernumber++;
		return service.getalluser();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserModel> getById(@PathVariable long id) {
//		getbyidnumber.incrementAndGet();
		getbyidnumber++;
		Optional<UserModel> u = service.getbyid(id);
		if (u.isPresent()) {
			return ResponseEntity.ok(u.get());
		} else {
			return null;
		}
	}

	@PostMapping("/users")
	public UserModel insertdata(@RequestBody UserModel user) {
//		insertdatanumber.incrementAndGet();
		insertdatanumber++;
		return service.createuser(user);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteuser(@PathVariable Long id) {
//		deletenumber.incrementAndGet();
		deletenumber++;
		service.deleteuser(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<UserModel> updateuser(@PathVariable Long id, @RequestBody UserModel data) {
//		updatenumber.incrementAndGet();
		updatenumber++;
		UserModel updateduser = service.updateuser(id, data);
		return ResponseEntity.ok(updateduser);
	}

	@GetMapping("/users/stats")
	public stat getstats() {
		stat status = new stat();
		status.setGetallusernumber(getallusernumber);
		status.setGetbyidnumber(getbyidnumber);
		status.setInsertdatanumber(insertdatanumber);
		status.setDeletenumber(deletenumber);
		status.setUpdatenumber(updatenumber);
		return status;
	}

}
//return service.getbyid();
