package com.smart.app.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.smart.app.service.UserService;
import com.smart.app.tools.HibernateUtil;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	
	private UserService userService;
	
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() throws Exception
	{
		int result = userService.validLogin(getUsername(), getPassword());
		if(result>0)
		{
			return SUCCESS;
		}
		return ERROR;
	}
	

}
