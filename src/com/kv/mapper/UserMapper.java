package com.kv.mapper;

import java.util.List;

import com.kv.model.User;

public interface UserMapper {

	public List<User> selectUser(User user);
	public void addUser(User user);
	public List<User> selectUserByName(String username);
	
}
