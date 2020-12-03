package com.sunset.service.impl;

import java.util.List;

import com.sunset.dao.HelpDao;
import com.sunset.dao.UserDao;
import com.sunset.dao.impl.HelpDaoImpl;
import com.sunset.dao.impl.UserDaoImpl;
import com.sunset.entity.AlreadyHelpList;
import com.sunset.entity.Help;
import com.sunset.entity.Old;
import com.sunset.entity.OldUserHelp;
import com.sunset.entity.User;
import com.sunset.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userdao = new UserDaoImpl();
	private HelpDao helpdao = new HelpDaoImpl();

	@Override
	public boolean userRegister(User user) {
		if (userdao.selectByName(user.getName())!=null) {
			System.out.println("用户名已存在！");
			return false;
		}
		return userdao.insertUser(user);
	}

	@Override
	public User userLogin(String name, String password) {
		return userdao.loginUser(name, password);
	}

	@Override
	public List<Old> showOldNeedHelp() {
		return helpdao.selectAllHelpOlds();
	}

	@Override
	public boolean helpOld(User user, int oldid) {
		return helpdao.helpOldById(user, oldid);
	}

	@Override
	public boolean addHelpDes(Help help) {
		return helpdao.addHelpDescriptionById(help);
	}

	@Override
	public List<AlreadyHelpList> showListHelpByUser(User user) {
		return helpdao.selectHelpsByUser(user);
	}

	@Override
	public List<OldUserHelp> showOldUserHelp(User user) {
		return helpdao.selectOldUserHelp(user);
	}
	
}
