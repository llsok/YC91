package com.yc.bbs.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bbs.biz.TopicBiz;
import com.yc.bbs.dao.TopicDao;
import com.yc.common.bean.Result;
import com.yc.common.biz.BizException;
import com.yc.common.web.BaseServlet;

@WebServlet("/topic.s")
public class TopicServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TopicDao tdao = new TopicDao();
	private TopicBiz tbiz = new TopicBiz();
	
	public void queryByBid(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		String bid = request.getParameter("bid");
		write(response, tdao.selectByBid(bid));
	}
	
	public void selectByIdWithReply(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		String id = request.getParameter("id");
		write(response, tdao.selectByIdWithReply(id));
	}

	public void add(HttpServletRequest request, 
			HttpServletResponse response) 
					throws IOException, SQLException{
		String boardid = request.getParameter("boardid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 发帖的前提：用户必须登录==》会话中有 loginedUser
		/*@SuppressWarnings("unchecked")
		Map<String,Object> loginedUser = 
				(Map<String, Object>) request.getSession()
					.getAttribute("loginedUser");
		Object uid = loginedUser.get("uid");*/
		Object uid = 1;
		
		try {
			tbiz.add(title,content,uid,boardid);
			write(response, Result.success("发帖成功！"));
		} catch (BizException e) {
			e.printStackTrace();
			write(response, Result.failure(e.getMessage()));
		}
	}

	public void reply(HttpServletRequest request, 
			HttpServletResponse response) 
					throws IOException, SQLException{
		String topicid = request.getParameter("topicid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 发帖的前提：用户必须登录==》会话中有 loginedUser
		/*@SuppressWarnings("unchecked")
		Map<String,Object> loginedUser = 
				(Map<String, Object>) request.getSession()
					.getAttribute("loginedUser");
		Object uid = loginedUser.get("uid");*/
		Object uid = 1;
		
		try {
			tbiz.reply(title, content, uid, topicid);
			write(response, Result.success("回帖成功！"));
		} catch (BizException e) {
			e.printStackTrace();
			write(response, Result.failure(e.getMessage()));
		}
	} 
}
