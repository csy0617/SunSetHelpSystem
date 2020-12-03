package com.sunset.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sunset.dao.HelpDao;
import com.sunset.entity.AlreadyHelpList;
import com.sunset.entity.Help;
import com.sunset.entity.Old;
import com.sunset.entity.OldUserHelp;
import com.sunset.entity.User;
import com.sunset.util.JDBCUtil;

public class HelpDaoImpl implements HelpDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

	@Override
	public List<Old> selectAllHelpOlds() {
		String sql = "select * from tb_Old where userid is null";
		List<Old> oldList = template.query(sql, new BeanPropertyRowMapper<Old>(Old.class));
		return oldList;
	}

	@Override
	public boolean helpOldById(User user,int oldid) {
		String sql = "update tb_Old set userid=? where oldid=?";
		return template.update(sql,user.getId(),oldid)>0?true:false;
	}

	@Override
	public boolean addHelpDescriptionById(Help help) {
		String sql = "insert into tb_Help values(null,?,?,now(),?)";
		return template.update(sql,help.getOldId(),help.getUserId(),help.getHelpDescription())>0?true:false;
	}

	@Override
	public List<AlreadyHelpList> selectHelpsByUser(User user) {
		//SELECT o.OldName,h.HelpDescription,h.AddTime FROM tb_Help h LEFT JOIN tb_Old o ON h.OldId=o.OldId WHERE h.UserId=1;
		String sql = "select o.oldname,h.helpdescription,h.addtime from tb_Help h left join tb_Old o on h.oldid=o.oldid where h.userid=? order by o.oldname";
		List<AlreadyHelpList> helpList = template.query(sql, new BeanPropertyRowMapper<AlreadyHelpList>(AlreadyHelpList.class),user.getId());
		return helpList;
	}

	@Override
	public List<OldUserHelp> selectOldUserHelp(User user) {
		//SELECT o.OldId,o.OldName FROM tb_Old o LEFT JOIN tb_User u ON o.UserId=u.Id WHERE o.UserId=1;
		String sql = "select o.oldid,o.oldname from tb_Old o left join tb_User u on o.userid=u.id where o.userid=?";
		List<OldUserHelp> olduserhelpList = template.query(sql, new BeanPropertyRowMapper<OldUserHelp>(OldUserHelp.class),user.getId());
		return olduserhelpList;
	}

}
