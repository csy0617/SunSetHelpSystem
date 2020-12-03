package com.sunset.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sunset.dao.OldDao;
import com.sunset.entity.Old;
import com.sunset.util.JDBCUtil;

public class OldDaoImpl implements OldDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

	@Override
	public boolean insertOld(Old old) {
		String sql = "insert into tb_Old values(null,?,now(),?,?,?,?,null)";
		int count = template.update(sql,old.getOldName(),old.getOldSex(),old.getOldAge(),old.getAddress(),old.getContact());
		return count>0?true:false;
	}

	@Override
	public List<Old> selectAllOlds() {
		String sql = "select * from tb_Old";
		List<Old> oldList = template.query(sql,new BeanPropertyRowMapper<Old>(Old.class));
		return oldList;
	}

	@Override
	public boolean deleteOldById(int id) {
		String sql = "delete from tb_Old where oldid=?";
		return template.update(sql,id)>0?true:false;
	}

	@Override
	public boolean updateOld(Old old) {
		String sql = "update tb_Old set oldage=?,address=?,contact=? where oldid=?";
		return template.update(sql,old.getOldAge(),old.getAddress(),old.getContact(),old.getOldId())>0?true:false;
	}

	@Override
	public Old selectByOldId(int id) {
		String sql ="select * from tb_Old where oldid=?";
		List<Old> oldList = template.query(sql,new BeanPropertyRowMapper<Old>(Old.class),id);
		if (oldList==null||oldList.size()==0) {
			return null;
		}
		return oldList.get(0);
	}

	@Override
	public Old selectByName(String oldname) {
		String sql = "select * from tb_Old where oldname=?";
		List<Old> oldList = template.query(sql, new BeanPropertyRowMapper<Old>(Old.class),oldname);
		if (oldList==null||oldList.size()==0) {
			return null;
		}
		return oldList.get(0);
	}

}
