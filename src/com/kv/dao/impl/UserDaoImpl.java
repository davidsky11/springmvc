package com.kv.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.kv.dao.IUserDao;
import com.kv.mapper.UserMapper;
import com.kv.model.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	@Resource
	private UserMapper userMapper;
	
//	private UUIDGenerator uuidGen = UUIDGenerator.getInstance();

	@Override
	public List<User> selectUser(User user) {
		return userMapper.selectUser(user);
	}

	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	@Override
	public List<User> selectUserByName(String username) {
		return userMapper.selectUserByName(username);
	}

}
