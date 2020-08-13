package com.yc.java.d0813;

import java.sql.*;

import com.yc.util.DBHelper;

public class Demo1 {
	
	public static void main(String[] args) {
		Demo1 d1 = new Demo1();
		/* 黑客 窃取资料 SQL注入攻击*/
		// d1.showDeptByName("事业部");
		d1.showDeptByName("事业部");
		System.out.println("=======================");
		//  ' or '1'='1 
		d1.showDeptByName("' or '1'='1");
	}
	
	public void showDeptByName(String dname) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			
			// ? 是查询参数占位符 表示一个查询查询(值)
			String sql = "select * from dept where dname = ?";
			// 创建预编译语句对象 ==> 它是普通语句对象的子类
			ps = conn.prepareStatement(sql);
			// 打印sql
			System.out.println(sql);
			//在执行语句前, 将参数设置到sql语句中, 用 setXXX
			ps.setString(1, dname);
			// 执行时不传 SQL 语句
			rs = ps.executeQuery();
			
			/**
			 * rs.next() 判断是否有下一行记录, 如果有返回true,并跳到下一行, 如果没返回false
			 * rs.getXXX(字段编号int  或 字段名String ) 返回当前行字段值  XXX 是数据的类型(基本数据类型, 字符串, 日期...)
			 */
			while (rs.next()) {
				System.out.println("编号: " + rs.getInt(1)); // 结果集的字段编号, 从 1 开始
				System.out.println("名称: " + rs.getString(2));
				System.out.println("位置: " + rs.getString("LOC")); // oracle
																	// 列名会自动转成大写
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, ps, conn);
		}
	}

	public void showDeptByNo(int deptno) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			stat = conn.createStatement();
			String sql = "select * from dept where deptno=" + deptno;
			rs = stat.executeQuery(sql);
			/**
			 * rs.next() 判断是否有下一行记录, 如果有返回true,并跳到下一行, 如果没返回false
			 * rs.getXXX(字段编号int  或 字段名String ) 返回当前行字段值  XXX 是数据的类型(基本数据类型, 字符串, 日期...)
			 */
			while (rs.next()) {
				System.out.println("编号: " + rs.getInt(1)); // 结果集的字段编号, 从 1 开始
				System.out.println("名称: " + rs.getString(2));
				System.out.println("位置: " + rs.getString("LOC")); // oracle
																	// 列名会自动转成大写
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stat, conn);
		}
	}

	/**
	 * 向scott数据库的dept添加一个部门"事业部" (  insert , update, delete ...)
	 */
	public static void addDept() throws ClassNotFoundException, SQLException {

		// Class 是类对象, 有一个静态方法 forName, 加载某个类
		// 参数是 数据库驱动类的类路径
		// ClassNotFoundException 编译期异常: 类未找到的异常
		System.out.println("开始");
		// 1. 加载驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. 获取连接
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "a";
		Connection conn = DriverManager.getConnection(url, user, password);
		// 3. 创建语句
		Statement stat = conn.createStatement();
		// 4.执行语句
		// 用于执行所有修改数据库的的语句,
		// 除了select 不能执行, 其他都可以执行, 包括: insert,delete,update, create xxx
		String sql = "insert into dept values (1, '财务部', '株洲')";
		int ret = stat.executeUpdate(sql);
		System.out.println("新增了" + ret + "个部门");
		// 关闭连接
		stat.close();
		conn.close(); // 如果直接关闭连接, 那么也就关闭了语句对象
		System.out.println("结束");

	}

}
