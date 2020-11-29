package com.yc.javaee.d1129;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload.do")
@MultipartConfig
public class UploadImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("imgfile");
		// 保存的web路径 /1129/axios/a.jpg
		// 获取应用上下文对象
		ServletContext sc = request.getServletContext();
		String webpath = "/1129/axios/" + part.getSubmittedFileName();
		String diskpath = sc.getRealPath(webpath);// 将web路径转换成磁盘路径
		part.write(diskpath);
		// getContextPath() 获取当前的工程名
		webpath = sc.getContextPath() + webpath;
		response.getWriter().append(webpath);
	}

}
