package com.kv.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.kv.dao.IUserDao;
import com.kv.model.Pager;
import com.kv.model.SystemContext;
import com.kv.model.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();
	}

	@Override
	public void update(User user) {
		Session session = sessionFactory.openSession();
		session.update(user);
		session.close();
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.openSession();
		User user = (User) session.load(User.class, id);
		session.delete(user);
		session.close();
	}

	@Override
	public User load(int id) {
		Session session = sessionFactory.openSession();
		User user = (User) session.load(User.class, id);
		session.close();
		
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		Session session = sessionFactory.openSession();
		List<User> users = session.createQuery("from User").list();
		session.close();
		
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<User> find() {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from User");
		query.setFirstResult(offset).setMaxResults(size);
		
		List<User> datas = query.list();
		Pager<User> us = new Pager<User>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
		long total = (Long) session
				.createQuery("select count(*) from User")
				.uniqueResult();
		us.setTotal(total);
		
		session.close();
		
		return us;
	}

	@Override
	public User loadByUsername(String username) {
		Session session = sessionFactory.openSession();
		User user = (User) session.createQuery("from User where username=?")
				.setParameter(0, username)
				.uniqueResult();
		session.close();
		
		return user;
	}

	@Override
	public User login(String username, String password) {
		Session session = sessionFactory.openSession();
		User user = (User) session.createQuery("from User where username=? and password=?")
				.setParameter(0, username)
				.setParameter(1, password)
				.uniqueResult();
		session.close();
		
		return user;
	}

}
