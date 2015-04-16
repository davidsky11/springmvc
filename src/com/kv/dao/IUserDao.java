package com.kv.dao;

import java.util.List;

import com.kv.domain.User;

public interface IUserDao {

	public User find(String username, String password);
	public void addUser(User user);
	public User selectUserByName(String username);
	public List<User> listUser();
	public void updateUser(User user);
	public void deleteUser(int id);
	public void deleteUser(User user);
	
}
