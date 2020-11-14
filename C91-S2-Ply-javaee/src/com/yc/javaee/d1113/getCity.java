package com.yc.javaee.d1113;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getCity")
public class getCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String[][] citys = AreaConstants.CITYS;
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		// 获取选项的 索引
		int name = Integer.parseInt(request.getParameter("pIndex"));
		List<String> list = new ArrayList<>();
		// 获取子列表
		for(int i=0; i<citys[name].length;i++){
			list.add(citys[name][i]);
		}
		response.getWriter().append((list.toString()));
		//System.out.println(list.toString());
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		doGet(request, response);
	}

}
