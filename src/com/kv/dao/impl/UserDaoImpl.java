package com.kv.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kv.dao.IUserDao;
import com.kv.model.Pager;
import com.kv.model.SystemContext;
import com.kv.model.User;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void add(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	@Override
	public void delete(Integer id) {
		User user = this.load(id);
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public User load(int id) {
		return this.getHibernateTemplate().load(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		return this.getSession().createQuery("from User").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<User> find() {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		
		Query query = this.getSession().createQuery("from User");
		query.setFirstResult(offset).setMaxResults(size);
		
		List<User> datas = query.list();
		Pager<User> us = new Pager<User>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
		long total = (Long) this.getSession()
				.createQuery("select count(*) from User")
				.uniqueResult();
		us.setTotal(total);
		
		return us;
	}

	@Override
	public User loadByUsername(String username) {
		return (User) this.getSession().createQuery("from User where username=?")
				.setParameter(0, username).uniqueResult();
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
