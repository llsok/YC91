package com.yc.javaee.d1114.singer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.javaee.d1114.singer.dao.SqSingerDao;

@WebServlet("/ssQueryCount.s")
public class QueryCountSqSingerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SqSingerDao ssDao = new SqSingerDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("" + ssDao.selectCount());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
