package com.yc.javaee.d1121;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * urlPatterns 定义该过滤器要过滤的资源（html,jsp,css,js,jpg...） 服务器的 URL 配置格式： 1. 精确配置， / 开头
 * Servlet 2. 文件后缀配置， *.xxx Filter 3. 目录匹配 /dir/*
 */
@WebFilter(urlPatterns = { "*.html" })
public class LoginFilter implements Filter {

	/**
	 * 销毁方法， 过滤器在服务器停止时，会执行该方法
	 */
	public void destroy() {
	}

	/**
	 * 过滤方法
	 * 
	 * ServletRequest request 请求 HttpServletRequest ServletResponse response 响应
	 * FilterChain chain 过滤器链对象
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();

		String path = httpRequest.getServletPath(); // 获取访问地址

		if (!(
				path.endsWith("login.html") 
				|| path.endsWith("register.html")
				|| path.endsWith("count.html"))) {
			if (session.getAttribute("loginedAccount") == null) {
				// 未登录 ==》 跳转登录页面 => 响应重定向（页面跳转）
				// 默认情况下 响应重定向地址中非西方文字会被转成 ????
				// 对地址进行编码
				/*
				 * String url = URLEncoder.encode(
				 * "/C91-S2-Ply-javaee/1113/简单的企业MIS/login.html", "utf-8");
				 */
				// httpResponse.sendRedirect(url);
				request.getRequestDispatcher("/1113/简单的企业MIS/login.html")
				.forward(httpRequest, httpResponse);
				return;
			}
		}

		// 正常的业务流转，必须要执行过滤器链的doFilter方法
		// 表示，继续执行后续的过滤器方法， 或者到达目标资源
		chain.doFilter(request, response);
	}

	/**
	 * 初始化
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
