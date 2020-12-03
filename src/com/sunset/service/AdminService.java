package com.sunset.service;

import java.util.List;

import com.sunset.entity.Administrator;
import com.sunset.entity.Old;

public interface AdminService {
	//注册
	boolean adminRegister(Administrator administrator);
	//登陆
	Administrator adminLogin(String name,String password);
	//录入老人信息
	boolean addOld(Old old);
	//查看老人信息
	List<Old> showAllOlds();
	//删除老人信息
	boolean deleteOld(int id);
	//修改老人信息
	boolean updateOld(Old old);
	//根据id查找老人
	Old findOldById(int id);
}
