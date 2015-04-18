package com.kv.dao;

import java.util.List;

import com.kv.domain.Role;
import com.kv.domain.User;

public interface IUserDao extends ICommonDao<User> {

	public User login(String username, String password);
	public User getByName(String username);
	public List<Role> listRole();
	
}
