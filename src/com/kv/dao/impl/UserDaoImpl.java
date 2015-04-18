package com.kv.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.kv.dao.IUserDao;
import com.kv.domain.Role;
import com.kv.domain.User;
import com.kv.domain.mappers.UserMapper;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	
	@Resource
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * 查找指定用户
	 */
	@Override
	public User login(String username, String password) {
		return userMapper.login(username, password);
	}

	/**
	 * 新增用户
	 */
	@Override
	public void add(User user) {
		userMapper.insert(user);
	}

	/**
	 * 根据用户名查找用户信息
	 */
	@Override
	public User getByName(String username) {

		return null;
	}

	/**
	 * 列举所有用户信息
	 */
	@Override
	public List<User> list() {
		
		return userMapper.list();
	}

	/**
	 * 更新用户信息到数据库
	 */
	@Override
	public void update(User user) {
		userMapper.update(user);
	}

	/**
	 * 删除指定用户信息
	 */
	@Override
	public void delete(int id) {
		userMapper.delete(id);
	}
	
	/**
	 * 删除指定用户信息
	 */
	@Override
	public void delete(User user) {
		
	}

	@Override
	public User getById(int id) {
		return userMapper.getById(id);
	}

	@Override
	public List<Role> listRole() {
		return userMapper.listRole();
	}

}
