package com.smart.app.dao;

import com.smart.app.model.User;

public interface UserDao extends BaseDao<User>{
	int ValidUser(String username,String password);
}
