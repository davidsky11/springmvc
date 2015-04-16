package com.kv.service;

import java.util.List;

import com.kv.domain.User;

public interface IUserService {

	public User login(String username, String password);
	public void register(User user);
	public User getUserByName(String username);
	public List<User> listAll();
	public void updateUser(User user);
	public void deleteUser(User user);
	
}
