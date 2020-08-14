package com.yc.java.d0814;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DBHelperTest {

	public static void main(String[] args) {
		DBHelper dbh = null;
		try {
			dbh = new DBHelper();
			String sql = "select * from dept where deptno=?";
			Map<String, Object> map = dbh.selectOne(sql, 10);
			System.out.println(map.get("DNAME"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbh.close();
		}

	}

	public void test2() {
		DBHelper dbh = null;
		try {
			dbh = new DBHelper();
			List<Map<String, Object>> list = dbh.select("select * from dept");
			for (Map<String, Object> m : list) {
				System.out.println(m);
			}

			System.out.println("==============================");
			list = dbh.select("select * from emp where sal > ?", 1000);
			for (Map<String, Object> m : list) {
				System.out.println(m);
			}

			System.out.println("==============================");
			list = dbh.select("select * from emp where sal between ? and ?", 1000, 2000);
			for (Map<String, Object> m : list) {
				System.out.println(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbh.close();
		}
	}

	public void test1() {
		DBHelper dbh = null;
		try {
			dbh = new DBHelper();
			dbh.update("insert into dept values(?,?,?)", 2, "网络部", "北京");
			dbh.update("update dept set dname=? where deptno=?", "技术部", 2);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbh.close();
		}
	}

}
