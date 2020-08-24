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
	
	public int update(String deptno, String dname, String loc) throws SQLException {
		// 业务潜规则 : 一般情况下不修改主键值
		String sql = "update dept set dname=?,loc=? where deptno=?";
		DBHelper dbh = null;
		try {
			dbh = new DBHelper();
			return dbh.update(sql, dname, loc, deptno);
		} finally {
			dbh.close();
		}
	}

	/**
	 * 新增: 判断指定部门是否已经存在
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
	
	/**
	 * 新增: 判断指定部门是否已经存在, 要排除自己的名称
	 * @param dname
	 * @param deptno
	 * @return
	 * @throws SQLException
	 */
	public int countByDname(String dname, String deptno) throws SQLException {
		String sql = "select * from dept where dname=? and deptno!=?";
		DBHelper dbh = null;
		try {
			dbh = new DBHelper();
			return dbh.count(sql, dname, deptno);
		} finally {
			dbh.close();
		}
	}

}
