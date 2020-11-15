package com.yc.javaee.d1114;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 服务器端 URL 地址里面的第一个 / 表示的是工程名后面的 /
 * 浏览器端 URL 地址里面的第一个 / 表示的是域名后面的 /
 * http://localhost/C91-S2-Ply-javaee/VerifyCodeServlet
 */
@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 在输出图片之前先获取 会话对象
		HttpSession session = request.getSession();
		// 获取验证码 + 将图片输出到浏览器
		String vcode = VerifyCodeUtils.outputImage(response);
		// 将验证码保存到 Session 对象中
		session.setAttribute("vcode", vcode);
		// 在生成验证码的时刻，除了保存验证码，还保存一个时间值
		session.setAttribute("vtime", new Date());
	}

}
