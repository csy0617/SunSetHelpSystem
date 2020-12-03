package com.sunset.dao;

import com.sunset.entity.Administrator;

public interface AdministratorDao {
	//注册管理员
	boolean insertAdmin(Administrator administrator);
	//登陆管理员
	Administrator loginAdmin(String adminname,String password);
	//根据名称查管理员
	Administrator selectByName(String adminname);
}
