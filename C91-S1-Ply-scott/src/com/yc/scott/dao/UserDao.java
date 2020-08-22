package com.yc.scott.dao;

import java.sql.SQLException;
import java.util.Map;

import com.yc.scott.util.DBHelper;

public class UserDao {
	
	public Map<String,Object> selectByLogin(String name, String pwd)
			throws SQLException{
		DBHelper dbh = null;
		try {
			dbh = new DBHelper();
			String sql = "select * from emp where ename=? and pwd=?";
			return dbh.selectOne(sql, name, pwd);
		} finally {
			dbh.close();
		}
	}

}
