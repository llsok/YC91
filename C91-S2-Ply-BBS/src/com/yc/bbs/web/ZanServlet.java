package com.yc.bbs.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bbs.biz.RedisBiz;

@WebServlet("/zan.s")
public class ZanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RedisBiz rbiz = new RedisBiz();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取点赞帖子的id
		String tid = request.getParameter("tid");
		// 从会话中获取当前登录人的id 
		String uid = "1";
		rbiz.zan(tid, uid);
		response.getWriter().append(" zan 成功 !!!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
