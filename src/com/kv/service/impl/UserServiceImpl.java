package com.kv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kv.dao.IUserDao;
import com.kv.exception.UserException;
import com.kv.model.Pager;
import com.kv.model.User;
import com.kv.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		User u = userDao.loadByUsername(user.getUsername());
		if (u != null)
			throw new UserException("要添加的用户已经存在！");
		userDao.add(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public User load(int id) {
		return userDao.load(id);
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Override
	public Pager<User> find() {
		return userDao.find();
	}

	@Override
	public User login(String username, String password) {
		User u = userDao.loadByUsername(username);
		if (u == null)
			throw new UserException("登陆用户不存在！");
		if (!u.getPassword().equals(password))
			throw new UserException("用户密码不正确!");
		return u;
	}

}
