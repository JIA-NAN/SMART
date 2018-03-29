package com.smart.app.dao;

import java.io.Serializable;
import java.util.List;


public interface BaseDao<T> {
	T get(Class<T> entityClazz,Serializable id);
	
	/* save entity */
	Serializable save(T entity);
	
	/* update entity */
	void update(T entity);
	
	/* delete entity */
	void delete(T entity);
	
	/* delete entity by id */
	void delete(Class<T> entityClazz,Serializable id);
	
	/* get all entities */
	List<T> findAll(Class<T> entityClazz);
	
	/* get total quantity */
	long findCount(Class<T> entityClazz);
}
