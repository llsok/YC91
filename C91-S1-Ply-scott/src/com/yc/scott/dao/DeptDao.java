package com.yc.scott.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yc.scott.util.DBHelper;

public class DeptDao {

	public List<Map<String, Object>> selectAll() throws SQLException {
		DBHelper dbh = null;
		try {
			dbh = new DBHelper();
			String sql = "select * from dept";
			return dbh.select(sql);
		} finally {
			dbh.close();
		}
	}

	public int insert(String deptno, String dname, String loc) throws SQLException {
		String sql = "insert into dept values (?,?,?)";
		DBHelper dbh = null;
		try {
			dbh = new DBHelper();
			return dbh.update(sql, deptno, dname, loc);
		} finally {
			dbh.close();
		}
	}

	/**
	 * 判断指定部门是否已经存在
	 * @param dname
	 * @return
	 * @throws SQLException
	 */
	public int countByDname(String dname) throws SQLException {
		String sql = "select * from dept where dname=?";
		DBHelper dbh = null;
		try {
			dbh = new DBHelper();
			return dbh.count(sql, dname);
		} finally {
			dbh.close();
		}
	}

}
