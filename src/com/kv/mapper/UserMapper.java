package com.kv.mapper;

import com.kv.model.User;

public interface UserMapper {

	public User find(String username);
	public void save(User user);
	
}
