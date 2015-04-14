package com.kv.dao;

import java.util.List;

import com.kv.model.User;

public interface IUserDao {

	public List<User> selectUser(User user);
	public void addUser(User user);
	public List<User> selectUserByName(String username);
	
}
