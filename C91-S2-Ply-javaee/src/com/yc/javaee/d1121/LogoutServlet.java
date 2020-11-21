package com.yc.javaee.d1121;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 退出 Servlet
 */
@WebServlet("/1113/简单的企业MIS/logout.s")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 *  会话失效：
		 *  	1. 自动失效 30分钟， 30分钟之内不与服务交互（点击链接）
		 *  	2. 手动失效
		 */
		request.getSession().invalidate();
		// 跳转到登录页面： 响应重定向
		response.sendRedirect("login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
