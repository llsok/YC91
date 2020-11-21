package com.yc.javaee.d1121;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userCount.s")
public class UserCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// UserCountListener ucl = new UserCountListener();
		// Servlet， Filter， Listener 服务器组件， 由服务器创建
		// 获取应用上下文对象中 在线总人数
		Integer count = (Integer) getServletContext().getAttribute("count");
		response.getWriter().append("" + ( count == null ? 0 : count) );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
