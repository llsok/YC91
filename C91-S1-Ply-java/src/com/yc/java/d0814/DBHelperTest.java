package com.yc.java.d0814;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import org.junit.Assert;

public class DBHelperTest {
	
	
	/**
	 * 作业: 请参考存款的方法,实现 转账业务
	 * 	1. 将 A 账户的资金转入B转换   (基本功能)
	 * 	2. 实现校验, 转出的金额不能大于 A 账户的金额, 如何判断?
	 */
	@Test
	public void testTransfer() {
		String sql1 = "update bank_account set balance = balance + ? where id = ?";
		String sql2 = "insert into bank_oprecord values ( bank_seq.nextval, ? , ? , sysdate)";
		DBHelper dbh = null;
		try {
			/**
			 * 假设 A 账号的id = 1, B账号的id = 2
			 */
			dbh = new DBHelper();
			/**
			 * 实现校验, 转出的金额不能大于 A 账户的金额, 如何判断?
			 */
			String sql = "select * from where id=? and balnace>=?";
			if( dbh.count(sql, 1, 1000) == 0) {
				System.out.println("金额不足");
				return;
			}
			if (dbh.update(sql1, - 1000, 1) == 1) {
				dbh.update(sql2, 1, - 1000);
				if (dbh.update(sql1, 1000, 2) == 1) {
					dbh.update(sql2, 2, 1000);
				}	
			}
			// 正常情况下要提交
			dbh.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// 异常情况下要回滚
			dbh.rollback();
		} finally {
			dbh.close();
		}
	}

	/**
	 * 测试数据库事务( Transactional )的方法
	 */
	@Test
	public void testTransactional() {
		String sql1 = "update bank_account set balance = balance + ? where id = ?";
		String sql2 = "insert into bank_oprecord values ( bank_seq.nextval, ? , ? , sysdate)";
		DBHelper dbh = null;
		try {
			dbh = new DBHelper();
			if (dbh.update(sql1, 1000, 1) == 1) {
				// 制造异常
				int i = 1 / 0;
				dbh.update(sql2, 1, 1000);
			}
			// 正常情况下要提交
			dbh.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// 异常情况下要回滚
			dbh.rollback();
		} finally {
			dbh.close();
		}
	}

	/**
	 * 真正意义上的测试    Junit ==> 自动化单元测试框架
	 */
	@Test
	public void testSelectPage() {
		String sql = "select * from emp";
		DBHelper dbh = null;
		try {
			dbh = new DBHelper();
			List<Map<String, Object>> page = dbh.selectPage(sql, 1, 5);
			/**
			 * 自动化验证, 使用断言判断
			 */
			Assert.assertEquals(5, page.size()); // 断言结果为 5
			Assert.assertEquals("武松", page.get(0).get("ENAME")); // 断言结果为 武松
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbh.close();
		}
	}

	@Test
	public void testGetValue() {
		String sql = "select max(sal) from emp";
		DBHelper dbh = null;
		try {
			dbh = new DBHelper();
			System.out.println(dbh.getValue(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbh.close();
		}
	}

	@Test
	public void testCount() {
		String sql = "select * from emp";
		DBHelper dbh = null;
		try {
			dbh = new DBHelper();
			System.out.println(dbh.count(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbh.close();
		}
	}

	// 单元测试 注解
	@Test
	public void test3() {
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

	@Test
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

	@Test
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
