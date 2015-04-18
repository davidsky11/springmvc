package com.kv.dao;

import java.util.List;

public interface ICommonDao<T> {

	public void add(T t);
	public void delete(T t);
	public void delete(int id);
	public void update(T t);
	public T getById(int id);
	public List<T> list();
	
}
