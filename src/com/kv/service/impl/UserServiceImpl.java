package com.kv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kv.mapper.UserMapper;
import com.kv.model.User;
import com.kv.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserMapper userMapper;

	@Override
	public User login(String username, String password) {
		return userMapper.find(username, password);
	}

	@Override
	public void register(User user) {
		userMapper.save(user);
	}

	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listAll() {
		return userMapper.listUser();
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}
	


}
