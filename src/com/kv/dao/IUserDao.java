package com.kv.dao;

import java.util.List;

import com.kv.model.Pager;
import com.kv.model.User;

public interface IUserDao {

	public void add(User user);
	public void update(User user);
	public void delete(Integer id);
	public User load(int id);
	public List<User> list();
	public Pager<User> find();
	public User loadByUsername(String username);
	public User login(String username, String password);
	
}
