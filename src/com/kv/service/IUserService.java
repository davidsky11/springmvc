package com.kv.service;

import com.kv.model.User;

public interface IUserService {

	public User query(String username);
	public void save(User user);
	public void testTransaction(User user1, User user2);
	
}
