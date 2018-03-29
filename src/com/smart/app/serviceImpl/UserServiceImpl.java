package com.smart.app.serviceImpl;

import com.smart.app.dao.UserDao;
import com.smart.app.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
	
	@Override
	public int validLogin(String uname, String pwd) {
		// TODO Auto-generated method stub
		return userDao.ValidUser(uname, pwd);
	}
	
}
