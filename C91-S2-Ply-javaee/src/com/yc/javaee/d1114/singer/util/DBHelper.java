package com.yc.javaee.d1114.singer.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBHelper {

	/**
	 * DBHelper 新内容 
	 * 1. 加入配置文件 .properties java 属性文件 Propertes ==> Map 
	 * 2. 引入实体类
	 * 		List<Map<String,Object>> selectList(sql,param...) 
	 * 		Map map = list.get(0); ==>
	 * 		row map.get("字段名"); List<实体类>selectList(sql,params...) 
	 * 3. 分页查询方法
	 */

	private static String driver;
	private static String url;
	private static String name;
	private static String pwd;

	/**
	 * 静态块，初始化
	 */
	static {
		try {
			// 读取配置文件 ==> 通过类加载器读取类路径里面的文件
			String path = "com/yc/javaee/d1114/singer/conn.properties";
			InputStream in = DBHelper.class.getClassLoader().getResourceAsStream(path);
			// 创建集合对象
			Properties prop = new Properties();
			prop.load(in);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			name = prop.getProperty("name");
			pwd = prop.getProperty("pwd");
			Class.forName(driver);
		} catch (Exception e) {
			// 异常转型 + 抛出运行期异常
			// 块不能直接抛出编译器异常
			throw new RuntimeException(e);
		}

	}

	/**
	 * 获取连接对象
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, name, pwd);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		System.out.println(conn);
		conn.close();

	}

}
