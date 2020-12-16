package com.yc.user.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload.s")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Part p = request.getPart("headimg");
		String filename = p.getSubmittedFileName();
		String webpath = "/head/" + filename;
		ServletContext sc = request.getServletContext();
		// 转换磁盘路径
		String diskpath = sc.getRealPath(webpath);
		System.out.println(diskpath);
		p.write(diskpath);
		// sc.getContextPath() 获取当前工程名
		webpath = sc.getContextPath() + webpath;
		response.getWriter().append(webpath);
	}

}
