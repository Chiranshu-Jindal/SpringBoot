package com.btidab.user.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.btidab.user.model.UserModel;
import com.btidab.user.repos.UserRepository;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repo;

	@Autowired
	private StatService stat;

	// Create
	public UserModel createuser(UserModel u) {
		logger.trace("enter createuser() method");
		logger.debug("incremented stat.insert count: {}", stat.incrementinsert());
		stat.incrementinsert();
		String encodedpassword = passwordEncoder.encode(u.getPassword());
		u.setPassword(encodedpassword);
		logger.warn("password is stored in encrypted form");
		logger.info("user successfully created");
		return repo.save(u);
	}

	// GetAll
	public List<UserModel> getalluser() {
		logger.trace("entering getalluser() method");
		logger.debug("incremented stat.getall count: {}", stat.incrementgetall());
		stat.incrementgetall();
		logger.info("retreived alluser data");
		return repo.findAll();
	}

	// GetById
	public Optional<UserModel> getbyid(long id) {
		logger.trace("entering getbyid() method");
		logger.debug("incremented stat.getbyid: {}", stat.incrementgetbyid());
		stat.incrementgetbyid();
		Optional<UserModel> user = repo.findById(id);
		if (user.isPresent()) {
			logger.info("user find with ID: {}", user);
		} else {
			logger.warn("user not found with id:{}", user);
		}
		return user;
	}

	// Delete
	public void deleteuser(Long id) {
		logger.trace("entering delete() method");
		logger.debug("incremented stat.delete: {}", stat.incrementdelete());
		stat.incrementdelete();
		try {
			repo.deleteById(id);
			logger.info("user deleted with id:{}", id);
		} catch (Exception e) {
			logger.error("user not found with Id:{}", id, e);
		}

	}

	// update
	public UserModel updateuser(Long id, UserModel data) {
		logger.trace("entering updateuser() method");
		logger.debug("incremented stat.updateuser: {}", stat.incrementupdate());
		stat.incrementupdate();

		UserModel a = repo.findById(id).orElseThrow(() -> {
			logger.warn("user not found with Id: {}", id);
			return new RuntimeException("User not found");
		});
		a.setUsername(data.getUsername());
		a.setPassword(data.getPassword());
		a.setFirst_name(data.getFirst_name());
		a.setLast_name(data.getLast_name());
		a.setEmail(data.getEmail());
		a.setTelephone(data.getTelephone());
		logger.info("user is updated successfully");
		return repo.save(a);

	}

}
//Optional<UserModel> a = repo.findById(id);
//if(a.isPresent())
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

//private AtomicInteger getallusernumber = new AtomicInteger();
//private AtomicInteger getbyidnumber = new AtomicInteger();;
//private AtomicInteger insertdatanumber = new AtomicInteger();;
//private AtomicInteger deletenumber = new AtomicInteger();;
//private AtomicInteger updatenumber = new AtomicInteger();;