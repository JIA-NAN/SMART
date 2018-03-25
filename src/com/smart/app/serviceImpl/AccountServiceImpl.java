package com.smart.app.serviceImpl;

import com.smart.app.service.AccountService;

public class AccountServiceImpl implements AccountService{

	@Override
	public int validLogin(String uname, String pwd) {
		// TODO Auto-generated method stub
		if(uname.equals("jn")&&pwd.equals("12345678"))
		{
			return 1;
		}
		return 0;
	}
	
}
