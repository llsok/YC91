package com.yc.javaee.d1113;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getXian")
public class getXian extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String[][][] xians = AreaConstants.COUNTYS;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		int name = Integer.parseInt(request.getParameter("pIndex"));
		int name1 = Integer.parseInt(request.getParameter("cIndex"));
		List<String> list = new ArrayList<>();
		for(int i=0; i<xians[name][name1].length;i++){
			list.add(xians[name][name1][i]);
		}
		response.getWriter().append((list.toString()));
		//System.out.println(list.toString());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
