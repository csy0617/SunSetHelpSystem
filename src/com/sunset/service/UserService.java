package com.sunset.service;

import java.util.List;

import com.sunset.entity.AlreadyHelpList;
import com.sunset.entity.Help;
import com.sunset.entity.Old;
import com.sunset.entity.OldUserHelp;
import com.sunset.entity.User;

public interface UserService {
	//注册
	boolean userRegister(User user);
	//登陆
	User userLogin(String name,String password);
	//查看需要帮扶的老人信息
	List<Old> showOldNeedHelp();
	//帮扶老人
	boolean helpOld(User user,int oldid);
	//记录帮扶事件
	boolean addHelpDes(Help help);
	//查看自己的帮扶事件
	List<AlreadyHelpList> showListHelpByUser(User user);
	//查看自己帮扶的老人
	List<OldUserHelp> showOldUserHelp(User user);
}
