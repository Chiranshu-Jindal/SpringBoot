package com.btidab.user.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btidab.user.model.StatModel;
import com.btidab.user.model.UserModel;
import com.btidab.user.repos.StatRepository;
import com.btidab.user.repos.UserRepository;

@Service
public class UserService {

	private int get_all_user = 0;
	private int get_by_id = 0;
	private int insert_data = 0;
	private int delete_user = 0;
	private int update_user = 0;

	@Autowired
	private UserRepository repo;

	@Autowired
	private StatRepository statrepo;

	// Create
	public UserModel createuser(UserModel u) {
		insert_data++;
		savestats();
		return repo.save(u);
	}

	// GetAll
	public List<UserModel> getalluser() {
		get_all_user++;
		savestats();
		return repo.findAll();
	}

	// GetById
	public Optional<UserModel> getbyid(long id) {
		get_by_id++;
		savestats();
		return repo.findById(id);
	}

	// Delete
	public void deleteuser(Long id) {
		delete_user++;
		savestats();
		repo.deleteById(id);
	}

	// update
	public UserModel updateuser(Long id, UserModel data) {
		update_user++;
		savestats();
		UserModel a = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		a.setUsername(data.getUsername());
		a.setPassword(data.getPassword());
		a.setFirst_name(data.getFirst_name());
		a.setLast_name(data.getLast_name());
		a.setEmail(data.getEmail());
		a.setTelephone(data.getTelephone());
		return repo.save(a);

	}

	// Stats
	public void savestats() {
		StatModel stat = new StatModel();
		stat.setGet_by_id(get_by_id);
		stat.setGet_all_user(get_all_user);
		stat.setDelete_user(delete_user);
		stat.setUpdate_user(update_user);
		stat.setInsert_data(insert_data);
		statrepo.save(stat);
	}

	public StatModel getstats() {
		StatModel status = new StatModel();
		status.setGet_by_id(get_by_id);
		status.setGet_all_user(get_all_user);
		status.setDelete_user(delete_user);
		status.setUpdate_user(update_user);
		status.setInsert_data(insert_data);
		return status;
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