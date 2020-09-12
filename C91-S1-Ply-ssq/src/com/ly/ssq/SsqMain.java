package com.ly.ssq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SsqMain {

	private String ssqfile = "D:\\文件柜\\91\\0912\\双色球.txt"; // 文件路径

	private List<String> ssqdata = new ArrayList<>(); // 文件内容集合

	// 读取文件
	public void read() {
		FileReader fr = null;
		BufferedReader br = null;
		// 定义文件字符流
		try {
			fr = new FileReader(ssqfile);
			// 缓冲处理流, 一次读入一行
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				ssqdata.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 写入数据库
	public void save() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			// 在循环外创建语句对象，
			String sql = "insert into LOTTERY values(SEQ_SSQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			for (String line : ssqdata) {
				String[] values = line.split("\\s+"); // 使用 空格 分割每个元素
				// 设置 12 个参数
				for (int i = 1; i <= 12; i++) {
					ps.setString(i, values[i - 1]);
				}
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 查询ssq数据
	public void query() {

	}

	public static void main(String[] args) {
		// 读入
		System.out.println("===========读入==========");
		SsqMain sm = new SsqMain();
		sm.read();
		for (String line : sm.ssqdata) {
			System.out.println(line);
		}
		
		// 保存到数据库
		System.out.println("===========保存到数据库==========");
		
		sm.save();
		
		System.out.println("===========完成==========");
	}

}
