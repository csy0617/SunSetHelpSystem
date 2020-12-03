package com.sunset.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sunset.dao.UserDao;
import com.sunset.entity.User;
import com.sunset.util.JDBCUtil;

public class UserDaoImpl implements UserDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

	@Override
	public boolean insertUser(User user) {
		String sql = "insert into tb_User values(null,?,?,?,?,?,?)";
		int count = template.update(sql,user.getName(),user.getUserName(),user.getPassword(),user.getSex(),user.getAge(),user.getPhone());
		return count>0?true:false;
	}

	@Override
	public User loginUser(String name, String password) {
		String sql = "select * from tb_User where name=? and password=?";
		List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class),name,password);
		if (userList==null||userList.size()==0) {
			return null;
		}
		return userList.get(0);
	}

	@Override
	public User selectByName(String name) {
		String sql = "select * from tb_User where username=?";
		List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class),name);
		if (userList==null||userList.size()==0) {
			return null;
		}
		return userList.get(0);
	}

}
