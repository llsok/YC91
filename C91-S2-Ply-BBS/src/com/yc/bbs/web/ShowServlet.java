package com.yc.bbs.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.common.web.BaseServlet;
@WebServlet("/show")
public class ShowServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void show(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		
		/*		Map<String, Object> list = new HashMap<>();
				
				list.put("uname", "1");
				list.put("upass", "123");
				request.getSession().setAttribute("loginedUser", list);
		*/		
		@SuppressWarnings("unchecked")
		Map<String,Object> loginedUser = 
				(Map<String, Object>) request.getSession()
					.getAttribute("loginedUser");
		
		write(response,loginedUser);
	}
	
}
