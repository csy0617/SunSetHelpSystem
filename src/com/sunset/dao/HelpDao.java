package com.sunset.dao;

import java.util.List;

import com.sunset.entity.AlreadyHelpList;
import com.sunset.entity.Help;
import com.sunset.entity.Old;
import com.sunset.entity.OldUserHelp;
import com.sunset.entity.User;

public interface HelpDao {
	//查看需要帮扶的老人信息
	List<Old> selectAllHelpOlds();
	//帮扶老人
	boolean helpOldById(User user,int oldid);
	//记录帮扶事件
	boolean addHelpDescriptionById(Help help);
	//查看自己的帮扶事件
	List<AlreadyHelpList> selectHelpsByUser(User user);
	//查看自己帮扶的老人
	List<OldUserHelp> selectOldUserHelp(User user);
}
