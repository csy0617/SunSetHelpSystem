package com.sunset.dao;

import java.util.List;

import com.sunset.entity.Old;

public interface OldDao {
	// 录入老人
	boolean insertOld(Old old);

	// 查看老人信息
	List<Old> selectAllOlds();

	// 删除老人的信息
	boolean deleteOldById(int id);

	// 修改老人的信息
	boolean updateOld(Old old);

	// 根据Id查看老人
	Old selectByOldId(int id);

	// 根据名称查老人
	Old selectByName(String oldname);
}
