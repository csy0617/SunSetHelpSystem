package com.sunset.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sunset.dao.AdministratorDao;
import com.sunset.entity.Administrator;
import com.sunset.util.JDBCUtil;

public class AdministratorDaoImpl implements AdministratorDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

	@Override
	public boolean insertAdmin(Administrator administrator) {
		String sql = "insert into tb_Administrator values(null,?,?,now())";
		int count = template.update(sql, administrator.getAdminName(), administrator.getPassword());
		return count > 0 ? true : false;
	}

	@Override
	public Administrator loginAdmin(String adminname, String password) {
		String sql = "select * from tb_Administrator where adminname=? and password=?";
		List<Administrator> adminList = template.query(sql, new BeanPropertyRowMapper<Administrator>(Administrator.class),adminname,password);
		if (adminList==null||adminList.size()==0) {
			return null;
		}
		return adminList.get(0);
	}

	@Override
	public Administrator selectByName(String adminname) {
		String sql = "select * from tb_Administrator where adminname=?";
		List<Administrator> adminList = template.query(sql, new BeanPropertyRowMapper<Administrator>(Administrator.class),adminname);
		if (adminList==null||adminList.size()==0) {
			return null;
		}
		return adminList.get(0);
	}

}
