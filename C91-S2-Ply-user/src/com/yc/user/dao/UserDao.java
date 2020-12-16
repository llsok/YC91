package com.yc.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.user.bean.User;
import com.yc.user.util.DBHelper;
import com.yc.user.util.DBHelper.ResultSetMapper;

public class UserDao {

	public void insert(User user) throws SQLException {
		String sql = "insert into user values(null,?,?,?,?,?,default)";
		DBHelper.update(sql, user.getName(), user.getPhone(), 
				user.getEmail(), user.getPwd(), user.getHead());
	}

	/**
	 * 查询是否有重名用户
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public int countByName(String name) throws SQLException {
		String sql = "select count(*) from user where name=?";
		List<Integer> list = DBHelper.selectList(sql, new ResultSetMapper<Integer>() {
			@Override
			public Integer map(ResultSet rs) throws SQLException {
				return rs.getInt(1);
			}
		}, name);
		return list.get(0);
	}

}