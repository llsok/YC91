package com.yc.javaee.d1114.singer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.javaee.d1114.singer.bean.SqSinger;
import com.yc.javaee.d1114.singer.dao.SqSingerDao;

@WebServlet("/ssQueryPage.s")
public class QueryPageSqSingerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SqSingerDao ssDao = new SqSingerDao();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String page = request.getParameter("page");
		
		int iPage = page == null ? 1 : Integer.parseInt(page);
		
		List<SqSinger> list = ssDao.selectPage(iPage);
		// 数据如何发送给浏览器 ？
		// 答： 使用 json 
		// 当前 JSON 格式
		// 答： [ {"id":1,name:"张三"。。。。   }, {}, {}     ]
		String json = new Gson().toJson(list);
		System.out.println(json);
		response.getWriter().append(json);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
