package com.yc.javaee.d1113;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getProvince")
public class getProvince extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String[] pros= AreaConstants.PROVINCES;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		List<String> list = new ArrayList<>();

		for(String n :pros) {
			list.add(n);		
		}
		response.getWriter().append(list.toString());
		//System.out.println(list.toString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
