package com.yc.java.d0814;

import java.sql.*;
import java.util.*;

public class DBHelper {

	// OOP : 类的构成元素-----静态块, 块不允许抛出编译期异常
	static {
		// 加载驱动只需要执行一次,以后再也不需要执行
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// 将该异常转换成运行期异常, 再抛出就没问题了
			throw new RuntimeException(e);
			// 运行期异常无感知
			// 编译期异常有感知
		}
	}

	private Connection conn;

	public DBHelper() throws SQLException {
		conn = getConnection();
	}

	/**
	 * 	创建连接
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "a";
		return DriverManager.getConnection(url, user, password);
	}

	/**
	 * 	定义执行sql语句的函数, 返回结果
	 * 
	 * String...param ==> String[] param
	 * @throws SQLException 
	 */
	public int update(String sql, Object... param) throws SQLException {
		// 创建预编译语句对象 ==> 它是普通语句对象的子类
		PreparedStatement ps = conn.prepareStatement(sql);
		// 打印sql 和 参数
		System.out.println("SQL: " + sql);
		System.out.println("参数: " + Arrays.toString(param));
		// 在执行语句前, 将参数设置到sql语句中, 用 setXXX
		for (int i = 0; i < param.length; i++) {
			ps.setObject(i + 1, param[i]);
		}
		// 执行时不传 SQL 语句
		return ps.executeUpdate();
	}

	/**
	 * 	查询方法, 
	 * @param sql
	 * @param param
	 * @return 返回查询结果
	 * @throws SQLException
	 */
	public List<Map<String, Object>> select(String sql, Object... param) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(sql);
		// 打印sql 和 参数
		System.out.println("SQL: " + sql);
		System.out.println("参数: " + Arrays.toString(param));
		// 在执行语句前, 将参数设置到sql语句中, 用 setXXX
		for (int i = 0; i < param.length; i++) {
			ps.setObject(i + 1, param[i]);
		}
		// 执行查询
		ResultSet rs = ps.executeQuery();
		// rs ==> List<Map<String, Object>>
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// rs 可以获取到 结果集的 "元数据对象" 元数据: 描述数据的数据
		ResultSetMetaData rsmd = rs.getMetaData();
		while (rs.next()) {
			// LinkedHashMap 有序不重复
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			/**
			 * 	重点: 注意rsmd的方法不要写错
			 */
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				String columnName = rsmd.getColumnName(i + 1);
				Object columnValue = rs.getObject(columnName);
				// 获取所有的字段名, 以及对应的字段值
				map.put(columnName, columnValue);
			}
			list.add(map);
		}
		return list;
	}

	/**
	 * 	查询一条记录(例如: 主键条件)
	 * @param sql
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> selectOne(String sql, Object... param) throws SQLException {
		List<Map<String, Object>> list = select(sql, param);
		return list.size() == 0 ? null : list.get(0);
	}
	
	/**
	 * 	返回当前sql查询的结果的数量
	 * @param sql
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public int count(String sql, Object... param) throws SQLException {
		return 0;
	}
	
	/**
	 * 	查询一个数值
	 * 	例如: select max(sal) form emp;
	 * 		select avg(sal) form emp;
	 * @param sql
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public Object getValue(String sql, Object... param) throws SQLException {
		return 0;
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
