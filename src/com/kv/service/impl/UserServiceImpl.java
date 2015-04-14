package com.kv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kv.dao.IUserDao;
import com.kv.model.User;
import com.kv.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
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
		List<User> userList = userDao.selectUserByName(username);
		if (userList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
