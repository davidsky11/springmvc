package com.kv.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.kv.dao.IUserDao;
import com.kv.model.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/**
	 * 查找指定用户
	 */
	@Override
	public List<User> selectUser(User user) {
//		SqlSession session = this.getSqlSession();
//		List<User> userList = session.selectList("user.selectUser", user);
//		return userList;
		
		SqlSession session = sqlSessionFactory.openSession();
		List<User> userList = null;
		try {
			userList = session.selectList("user.selectUser", user);
		} finally {
			session.close();
		}
		
		return userList;
	}

	/**
	 * 新增用户
	 */
	@Override
	public void addUser(User user) {
//		SqlSession session = this.getSqlSession();
//		session.insert("user", user);
	
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("user.addUser", user);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * 根据用户名查找用户信息
	 */
	@Override
	public User selectUserByName(String username) {
//		SqlSession session = this.getSqlSession();
//		User user = session.selectOne("user.selectUserByName", username);
//		return user;
		
		SqlSession session = sqlSessionFactory.openSession();
		User user = null;
		try {
			user = session.selectOne("user.selectUserByName", username);
		} finally {
			session.close();
		}
		
		return user;
	}

	/**
	 * 列举所有用户信息
	 */
	@Override
	public List<User> listUser() {
//		SqlSession session = this.getSqlSession();
//		List<User> userList = session.selectList("user.listUser");
//		return userList;
		
		SqlSession session = sqlSessionFactory.openSession();
		List<User> userList = null;
		try {
			userList = session.selectList("user.listUser");
		} finally {
			session.close();
		}
		
		return userList;
	}

	/**
	 * 更新用户信息到数据库
	 */
	@Override
	public void updateUser(User user) {
//		SqlSession session = this.getSqlSession();
//		session.update("user.updateUser", user);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("user.updateUser", user);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * 删除指定用户信息
	 */
	@Override
	public void deleteUser(int id) {
//		SqlSession session = this.getSqlSession();
//		session.delete("user.deleteUser", id);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("user.deleteUser", id);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	/**
	 * 删除指定用户信息
	 */
	@Override
	public void deleteUser(User user) {
//		SqlSession session = this.getSqlSession();
//		session.delete("user.deleteUser", user);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("user.updateUser", user);
			session.commit();
		} finally {
			session.close();
		}
	}

}
