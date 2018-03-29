package com.smart.app.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.smart.app.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory()
	{
		return this.sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz,Serializable id)
	{
		return (T)getSessionFactory().getCurrentSession().get(entityClazz, id);
	}
	

	@Override
	public Serializable save(T entity) {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().save(entity);
	}
	
	

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(entity);
	}

	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().createQuery("delete "+entityClazz.getSimpleName()+" en where en.id= ?0")
		.setParameter("0", id)
		.executeUpdate();
	}

	@Override
	public List<T> findAll(Class<T> entityClazz) {
		// TODO Auto-generated method stub
		return find("select en from "+entityClazz.getSimpleName()+" en");
	}

	@Override
	public long findCount(Class entityClazz) {
		// TODO Auto-generated method stub
		List<?> list = find("select count(*) from "+entityClazz.getSimpleName());
		if(list !=null && list.size()==1)
		{
			return (Long)list.get(0);
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql)
	{
		return (List<T>)getSessionFactory().getCurrentSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object... params)
	{
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i=0,len=params.length;i<len;i++)
		{
			query.setParameter(i+"", params[i]);
		}
		return (List<T>)query.list();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize)
	{
		return getSessionFactory().getCurrentSession().createQuery(hql).setFirstResult((pageNo-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize,Object...params)
	{
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i = 0,len=params.length;i<len;i++)
		{
			query.setParameter(i+"", params[i]);
		}
		return query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
	}
}
