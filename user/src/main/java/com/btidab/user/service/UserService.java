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

	//Create
	public UserModel createuser(UserModel u) {
		return repo.save(u);
	}
	//GetAll
	public List<UserModel> getalluser() {
		return repo.findAll();
	}
	//GetById
	public Optional<UserModel> getbyid(long id){
		return repo.findById(id);
	}
	//Delete
	public void deleteuser(Long id) {
		repo.deleteById(id);
	}
	
}
