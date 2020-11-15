package com.yc.javaee.d1113;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ToHomeworkServlet")
public class ToHomeworkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
		// 创建 cookie
		Cookie cookie = new Cookie("a", "1");
		// 默认情况下，cookie 有效时间是“会话结束时” ==》 关闭浏览器的时候
		// 将maxAge 设置为 0 表示 删除cookie
		cookie.setMaxAge(60);
		// 添加cookie数据
		response.addCookie(cookie);
		
		// 跳转页面 到 省市县联动.html
		request.getRequestDispatcher("1113/省市县联动.html")
			.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
