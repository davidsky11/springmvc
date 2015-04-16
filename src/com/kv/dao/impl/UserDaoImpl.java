package com.kv.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.kv.dao.IUserDao;
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

//	private SqlSession sqlSession;
//	
//	public SqlSession getSqlSession() {
//		return sqlSession;
//	}
//
//	@Resource
//	public void setSqlSession(SqlSession sqlSession) {
//		this.sqlSession = sqlSession;
//	}

	/**
	 * 查找指定用户
	 */
	@Override
	public User find(String username, String password) {
//		SqlSession session = this.getSqlSession();
//		List<User> userList = session.selectList("user.selectUser", user);
//		return userList;
		
		return userMapper.find(username, password);
	}

	/**
	 * 新增用户
	 */
	@Override
	public void addUser(User user) {
//		SqlSession session = this.getSqlSession();
//		session.insert("user", user);
	
		userMapper.insert(user);
	}

	/**
	 * 根据用户名查找用户信息
	 */
	@Override
	public User selectUserByName(String username) {
//		SqlSession session = this.getSqlSession();
//		User user = session.selectOne("user.selectUserByName", username);
//		return user;
		
//		SqlSession session = sqlSessionFactory.openSession();
//		User user = null;
//		try {
//			user = session.selectOne("user.selectUserByName", username);
//		} finally {
//			session.close();
//		}
//		
//		return user;
		
		return null;
	}

	/**
	 * 列举所有用户信息
	 */
	@Override
	public List<User> listUser() {
//		SqlSession session = this.getSqlSession();
//		List<User> userList = session.selectList("user.listUser");
//		return userList;
		
//		SqlSession session = sqlSessionFactory.openSession();
//		List<User> userList = null;
//		try {
//			userList = session.selectList("user.listUser");
//		} finally {
//			session.close();
//		}
//		
//		return userList;
		
		return userMapper.list();
	}

	/**
	 * 更新用户信息到数据库
	 */
	@Override
	public void updateUser(User user) {
//		SqlSession session = this.getSqlSession();
//		session.update("user.updateUser", user);
		
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			session.update("user.updateUser", user);
//			session.commit();
//		} finally {
//			session.close();
//		}
		
		userMapper.update(user);
	}

	/**
	 * 删除指定用户信息
	 */
	@Override
	public void deleteUser(int id) {
//		SqlSession session = this.getSqlSession();
//		session.delete("user.deleteUser", id);
		
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			session.delete("user.deleteUser", id);
//			session.commit();
//		} finally {
//			session.close();
//		}
		
		userMapper.delete(id);
	}
	
	/**
	 * 删除指定用户信息
	 */
	@Override
	public void deleteUser(User user) {
//		SqlSession session = this.getSqlSession();
//		session.delete("user.deleteUser", user);
		
//		SqlSession session = sqlSessionFactory.openSession();
//		try {
//			session.delete("user.updateUser", user);
//			session.commit();
//		} finally {
//			session.close();
//		}
		
		
	}

}
