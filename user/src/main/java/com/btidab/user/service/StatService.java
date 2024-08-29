package com.btidab.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btidab.user.model.StatModel;
import com.btidab.user.repos.StatRepository;

@Service
public class StatService {

	@Autowired
	private StatRepository statrepo;

	private StatModel loadstat() {
		return statrepo.findById(1L).orElseGet(() -> {
			StatModel stat = new StatModel();
			stat.setGet_by_id(0);
			stat.setGet_all_user(0);
			stat.setDelete_user(0);
			stat.setInsert_data(0);
			stat.setUpdate_user(0);
			return stat;
		});
	}

	public void savestats(StatModel stat) {
		statrepo.save(stat);
	}

	public void incrementid() {
		StatModel stat = new StatModel();
		long count = stat.getId();
		stat.setId(count + 1);
		savestats(stat);
	}

	public void incrementgetbyid() {
		StatModel stat = new StatModel();
		int count = stat.getGet_by_id();
		stat.setGet_by_id(count + 1);
		savestats(stat);
	}

	public void incrementgetall() {
		StatModel stat = new StatModel();
		int count = stat.getGet_all_user();
		stat.setGet_all_user(count + 1);
		savestats(stat);
	}

	public void incrementdelete() {
		StatModel stat = new StatModel();
		int count = stat.getDelete_user();
		stat.setDelete_user(count + 1);
		savestats(stat);
	}

	public void incrementinsert() {
		StatModel stat = new StatModel();
		stat.setInsert_data(stat.getInsert_data());
		savestats(stat);
	}

	public void incrementupdate() {
		StatModel stat = new StatModel();
		int count = stat.getUpdate_user();
		stat.setUpdate_user(count + 1);
		savestats(stat);
	}

	public StatModel getstats() {
		return loadstat();
	}
}
