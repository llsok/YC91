package com.yc.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.user.bean.User;
import com.yc.user.biz.BizException;
import com.yc.user.biz.UserBiz;

/**
 * 1.继承 HttpServlet 2.重写 doGet，doPost 。。。 3.配置 xml + 注解
 */
@WebServlet("/register.s")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserBiz ubiz = new UserBiz();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		// 将请求的参数设置到实体对象中
		User user = new User();
		user.setName(req.getParameter("name"));
		user.setPhone(req.getParameter("phone"));
		user.setEmail(req.getParameter("email"));
		user.setHead(req.getParameter("head"));
		user.setPwd(req.getParameter("pwd"));
		try {
			// 调用业务方法
			ubiz.register(user);
			resp.getWriter().append("注册成功");
		} catch (BizException e) {
			e.printStackTrace();
			resp.getWriter().append("注册失败！原因：" + e.getMessage());
		}
	}
	
	/**
	 * 测试用的方法
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
