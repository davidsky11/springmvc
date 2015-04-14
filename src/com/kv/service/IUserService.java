package com.kv.service;

import java.util.List;

import com.kv.model.User;

public interface IUserService {

	public List<User> selectUser(User user);
	public void addUser(User user);
	public boolean existUser(String username);
}
