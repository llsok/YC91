package com.yc.javaee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add.s")
public class AddSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sa = request.getParameter("a");
		String sb = request.getParameter("b");

		int sum = Integer.parseInt(sa) + Integer.parseInt(sb);

		response.getWriter().append("" + sum);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 作业：
	 * 	1. 使用一个Servlet 实现加减乘除
	 * 	2. 必须使用 post 请求提交数字 ==》 表单
	 */
	

}
