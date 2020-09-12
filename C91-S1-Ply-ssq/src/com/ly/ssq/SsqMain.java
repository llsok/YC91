package com.ly.ssq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

	}

	// 查询ssq数据
	public void query() {

	}
	
	public static void main(String[] args) {
		SsqMain sm = new SsqMain();
		sm.read();
		for(String line : sm.ssqdata) {
			System.out.println(line);
		}
	}

}
