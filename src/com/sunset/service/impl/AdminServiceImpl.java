package com.sunset.service.impl;

import java.util.List;

import com.sunset.dao.AdministratorDao;
import com.sunset.dao.OldDao;
import com.sunset.dao.impl.AdministratorDaoImpl;
import com.sunset.dao.impl.OldDaoImpl;
import com.sunset.entity.Administrator;
import com.sunset.entity.Old;
import com.sunset.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdministratorDao admindao = new AdministratorDaoImpl();
	private OldDao olddao = new OldDaoImpl();

	@Override
	public boolean adminRegister(Administrator administrator) {
		if (admindao.selectByName(administrator.getAdminName())!=null) {
			System.out.println("管理员名已存在！");
			return false;
		}
		return admindao.insertAdmin(administrator);
	}

	@Override
	public Administrator adminLogin(String name, String password) {
		return admindao.loginAdmin(name, password);
	}

	@Override
	public boolean addOld(Old old) {
		return olddao.insertOld(old);
	}

	@Override
	public List<Old> showAllOlds() {
		return olddao.selectAllOlds();
	}

	@Override
	public boolean deleteOld(int id) {
		return olddao.deleteOldById(id);
	}

	@Override
	public boolean updateOld(Old old) {
		return olddao.updateOld(old);
	}

	@Override
	public Old findOldById(int id) {
		return olddao.selectByOldId(id);
	}

}
