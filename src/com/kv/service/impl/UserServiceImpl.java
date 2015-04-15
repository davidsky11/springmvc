package com.kv.service.impl;

import java.util.List;

import com.kv.dao.IUserDao;
import com.kv.model.User;
import com.kv.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> selectUser(User user) {
		return userDao.selectUser(user);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public boolean existUser(String username) {
		User user = userDao.selectUserByName(username);
		if (null != user) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User selectUserByName(String username) {
		return userDao.selectUserByName(username);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	@Override
	public List<User> listUser() {
		return userDao.listUser();
	}

}
