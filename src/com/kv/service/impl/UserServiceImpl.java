package com.kv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kv.domain.Role;
import com.kv.domain.User;
import com.kv.domain.mappers.UserMapper;
import com.kv.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserMapper userMapper;

	@Override
	public User login(String username, String password) {
		return userMapper.login(username, password);
	}

	@Override
	public void register(User user) {
		userMapper.insert(user);
	}

	@Override
	public User getUserByName(String username) {
		return userMapper.getUserByName(username);
	}

	@Override
	public List<User> listAll() {
		return userMapper.list();
	}

	@Override
	public void updateUser(User user) {
		userMapper.update(user);
	}

	@Override
	public void deleteUser(User user) {
		userMapper.delete(user.getUserId());
	}

	@Override
	public List<Role> listRole() {
		return userMapper.listRole();
	}

}
