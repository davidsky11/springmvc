package com.kv.dao;

import com.kv.model.User;

public interface IUserDao {

	public void add(User user);
	public void delete(User user);
	public void update(User user);
	public User getById(int id);
	public int countAll();
	
	
}
