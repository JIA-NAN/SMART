package com.smart.app.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.smart.app.tools.HibernateUtil;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
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
		int number = 0;
		System.out.println(getUsername()+"  "+"sdqwqwdq");
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			number = session.createQuery("select u from User u where name = :name").setString("name", getUsername()).list().size();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(number>0)
		{
			return SUCCESS;
		}
		return ERROR;
	}

}
