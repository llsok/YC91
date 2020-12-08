package com.yc.javaee.d1129;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 地址全局唯一
@WebServlet("/add.do")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String oper = request.getParameter("oper");
		int iNum1 = num1 == null ? 0 : Integer.parseInt(num1);
		int iNum2 = num2 == null ? 0 : Integer.parseInt(num2);
		int result = 0;
		switch (oper) {
		case "+":
			result = iNum1 + iNum2;
			break;
		case "-":
			result = iNum1 - iNum2;
			break;
		// 其他运算符的计算请自行扩展
		}
		response.getWriter().append("" + result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
