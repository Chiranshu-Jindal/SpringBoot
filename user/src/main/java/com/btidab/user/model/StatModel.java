package com.btidab.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stat_data")
public class StatModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;

	@Column(name = "get_by_id")
	private int get_by_id;

	@Column(name = "get_all_user")
	private int get_all_user;

	@Column(name = "insert_data")
	private int insert_data;

	@Column(name = "update_user")
	private int update_user;

	@Column(name = "delete_user")
	private int delete_user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getGet_by_id() {
		return get_by_id;
	}

	public void setGet_by_id(int get_by_id) {
		this.get_by_id = get_by_id;
	}

	public int getGet_all_user() {
		return get_all_user;
	}

	public void setGet_all_user(int get_all_user) {
		this.get_all_user = get_all_user;
	}

	public int getInsert_data() {
		return insert_data;
	}

	public void setInsert_data(int insert_data) {
		this.insert_data = insert_data;
	}

	public int getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(int update_user) {
		this.update_user = update_user;
	}

	public int getDelete_user() {
		return delete_user;
	}

	public void setDelete_user(int delete_user) {
		this.delete_user = delete_user;
	}

}
