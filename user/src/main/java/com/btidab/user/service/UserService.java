package com.btidab.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btidab.user.model.UserModel;
import com.btidab.user.repos.UserRepositery;

@Service
public class UserService {

	@Autowired
	private UserRepositery repo;

	// Create
	public UserModel createuser(UserModel u) {
		return repo.save(u);
	}

	// GetAll
	public List<UserModel> getalluser() {
		return repo.findAll();
	}

	// GetById
	public Optional<UserModel> getbyid(long id) {
		return repo.findById(id);
	}

	// Delete
	public void deleteuser(Long id) {
		repo.deleteById(id);
	}

	// update
	public UserModel updateuser(Long id, UserModel data) {

		UserModel a = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		a.setUsername(data.getUsername());
		a.setPassword(data.getPassword());
		a.setFirst_name(data.getFirst_name());
		a.setLast_name(data.getLast_name());
		a.setEmail(data.getEmail());
		a.setTelephone(data.getTelephone());
		return repo.save(a);
	}

}

//Optional<UserModel> a = repo.findById(id);if(a.isPresent())
//{
//	a.setUsername(data.getUsername());
//	a.setPassword(data.getPassword());
//	a.setFirst_name(data.getFirst_name());
//	a.setLast_name(data.getLast_name());
//	a.setEmail(data.getEmail());
//	a.setTelephone(data.getTelephone());
//	return repo.save(a);
//	
//}
