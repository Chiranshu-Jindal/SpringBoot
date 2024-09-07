package com.btidab.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btidab.user.model.StatModel;
import com.btidab.user.repos.StatRepository;

@Service
public class StatService {
	private static final Logger logger = LoggerFactory.getLogger(StatService.class);
	@Autowired
	private StatRepository statrepo;

	private StatModel loadstat() {
		logger.info("creating or checking if Stat data is present");
		return statrepo.findById(1L).orElseGet(() -> {
			StatModel stat = new StatModel();
			stat.setGet_by_id(0);
			stat.setGet_all_user(0);
			stat.setDelete_user(0);
			stat.setInsert_data(0);
			stat.setUpdate_user(0);
			logger.info("object of StatService Class is initialized successfully");
			return stat;
		});
	}

	public void savestats(StatModel stat) {
		statrepo.save(stat);
		logger.info("saving stats data into database");
	}

	public void incrementid() {
		StatModel stat = loadstat();
		long count = stat.getId();
		stat.setId(count + 1);
		savestats(stat);
		logger.info("getbyid stat incremented, count {}", stat.getGet_by_id());
		logger.debug("detailed debug info: get_by_id stat incremented successfully");
		logger.trace("Trace level log for get_by_id stat");
	}

	public StatModel incrementgetbyid() {
		StatModel stat = loadstat();
		int count = stat.getGet_by_id();
		stat.setGet_by_id(count + 1);
		savestats(stat);
		logger.info("getbyid incremented, count {}", stat.getGet_by_id());
		logger.debug("detailed debug info: get_by_id stat incremented successfully");
		logger.trace("Trace level log for get_by_id stat");
		return stat;
	}

	public StatModel incrementgetall() {
		StatModel stat = loadstat();
		int count = stat.getGet_all_user();
		stat.setGet_all_user(count + 1);
		savestats(stat);
		logger.info("getall incremented, count {}", stat.getGet_all_user());
		logger.debug("detailed debug info: getall stat incremented successfully");
		logger.trace("Trace level log for getall stat");
		return stat;
	}

	public StatModel incrementdelete() {
		StatModel stat = loadstat();
		int count = stat.getDelete_user();
		stat.setDelete_user(count + 1);
		savestats(stat);
		logger.info("delete user is called, count {}", stat.getDelete_user());
		logger.debug("detailed debug info: delete user stat incremented successfully");
		logger.trace("Trace level log for delete stat");
		return stat;
	}

	public StatModel incrementinsert() {
		StatModel stat = loadstat();
		stat.setInsert_data(stat.getInsert_data());
		savestats(stat);
		logger.info("insert incremented, count {}", stat.getInsert_data());
		logger.debug("detailed debug info: insert stat incremented successfully");
		logger.trace("Trace level log for insert stat");
		return stat;
	}

	public StatModel incrementupdate() {
		StatModel stat = loadstat();
		int count = stat.getUpdate_user();
		stat.setUpdate_user(count + 1);
		savestats(stat);
		logger.info("getall incremented, count {}", stat.getGet_all_user());
		logger.debug("detailed debug info: getall incremented successfully");
		logger.trace("Trace level log for getall");
		return stat;
	}

	public StatModel getstats() {
		logger.info("Fetching Stats data");
		StatModel stat = loadstat();
		if (stat == null) {
			logger.warn("no stats found, returning default values.");
		}
		return loadstat();
	}
}
