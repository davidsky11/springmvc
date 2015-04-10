package com.kv.service;

import java.util.List;

import com.kv.model.Pager;
import com.kv.model.User;

public interface IUserService {

	public void add(User user);
	public void update(User user);
	public void delete(Integer id);
	public User load(int id);
	public List<User> list();
	public Pager<User> find();
	public User login(String username, String password);
	
}
