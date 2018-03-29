package com.smart.app.daoImpl;

import com.smart.app.dao.UserDao;
import com.smart.app.model.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	public int ValidUser(String username,String password)
	{
		String hql = "select u from User u where u.name= ?0 and u.password= ?1";
		return find(hql,new String[] {username,password}).size();
	}
}	
