package com.yc.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Servlet 映射地址 必须 / 开头
 *
 */
@WebServlet(name = "demo", urlPatterns = { "/demo.s", "/de.s" }, 
	initParams = {
		@WebInitParam(name = "company", value = "yc"),
		@WebInitParam(name = "welcome", value = "欢迎")
	}
)
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 应用上下文接口 => 应用上下文对象
		// 是一个全局的储存信息的空间，服务器开始，其就存在，服务器关闭，其才释放
		System.out.println(this.getServletContext());
		System.out.println(req);
		System.out.println(resp);
		System.out.println(req.getHeader("Accept-Encoding"));
		
		/**
		 * 请求参数：
		 * get 方式的请求参数
		 * 127.0.0.1/A/a.s?a=1&b=2&c=3
		 * post 比较复杂
		 * 
		 * http://127.0.0.1:8080/C91-S2-Ply-javaee/demo.s?name=？？？？
		 * 
		 * 页面输出 你好 ？？？？
		 * 
		 */
		String name = req.getParameter("name");
		resp.setContentType("text/html; charset=utf-8");
		// 返回响应输出流
		PrintWriter out = resp.getWriter();
		out.print("<h1>你好 "+name+"</h1>");
		
		/**
		 * 传2数字， 返回数字之和
		 */
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 读取初始化参数
		System.out.println(config.getInitParameter("company"));
		System.out.println(config.getInitParameter("welcome"));
		super.init(config);
	}

	
	
	
}
