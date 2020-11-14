package com.yc.javaee.d1113;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/1113/简单的企业MIS/login.s")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取账号
		String account = request.getParameter("account");
		// 获取账号
		String pwd = request.getParameter("pwd");
		// 获取请求中的验证码
		String rvcode = request.getParameter("vcode");
		// 获取会话中的验证码
		String svcode = (String) request.getSession().getAttribute("vcode");
		// 对比验证码
		if(svcode.equalsIgnoreCase(rvcode) == false ) {
			response.getWriter().append("-1");
			return;
		}
		
//		System.out.println("====="+account);
//		System.out.println("====="+pwd);
		
		if("zhangsan".equals(account) && "123".equals(pwd)) {
			// 登录成功！
			// 获取会话对象
			HttpSession session = request.getSession();
			// 存入当前登录的用户名
			session.setAttribute("loginedAccount", account);
			
			// 将账号保存到cookie中
			Cookie cookie = new Cookie("loginedAccount",account);
			cookie.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie);
			response.getWriter().append("1");
		} else {
			// 登录失败
			response.getWriter().append("0");
		}
		
	}

}
