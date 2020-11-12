package com.yc.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 继承 
 * 重写 
 * 配置  : 1 注解    2 web.xml*/
// 注解是给机器看的， 注释是给人看的
// 配置的字符串表示： 访问该Servlet的URL地址
/**
 * The servlets named 
 * [hello] and 
 * [com.yc.javaee.servlet.HelloServlet] are 
 * both mapped to the url-pattern [/hello.s] which is not permitted
 * 
 * servlet 地址配置冲突（地址重复）
 *
 */
@WebServlet("/hello.s")
public class HelloServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(
			// 请求对象 ==》 封装了浏览器发送的请求信息
			HttpServletRequest req,
			// 响应对象 ==》 服务器回传数据的对象
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// 告诉浏览器， 我要给你什么数据    ContentType => 内容类型
		resp.setContentType("text/html; charset=utf-8");
		// 返回响应输出流
		PrintWriter out = resp.getWriter();
		out.print("<h1>Hello world</h1>");
	}
	
	protected void doPost(
			// 请求对象 ==》 封装了浏览器发送的请求信息
			HttpServletRequest req,
			// 响应对象 ==》 服务器回传数据的对象
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// 告诉浏览器， 我要给你什么数据    ContentType => 内容类型
		resp.setContentType("text/html; charset=utf-8");
		// 返回响应输出流
		PrintWriter out = resp.getWriter();
		out.print("<h1>Hello world with post</h1>");
	}
	

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("============= service ============");
		super.service(arg0, arg1);
	}

	@Override
	public void destroy() {
		System.out.println("============= destroy ============");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("============= init ============");
		super.init();
	}
	
	
	
	
	
	
	

}
