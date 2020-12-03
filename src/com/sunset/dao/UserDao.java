package com.sunset.dao;

import com.sunset.entity.User;

public interface UserDao {
	// 注册用户
	boolean insertUser(User user);

	// 根据用户名和密码登陆
	User loginUser(String name, String password);

	// 根据名称查用户
	User selectByName(String name);
}
