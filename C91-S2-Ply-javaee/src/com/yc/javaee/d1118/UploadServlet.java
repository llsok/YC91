package com.yc.javaee.d1118;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

@WebServlet("/upload.s")
/**
 * 基于 Servlet 3.0 以上版本   3.0以前不支持文件上传， 只能使用第三方组件  apache smartupload
 * 
 * maxFileSize  单个文件大小限定
 * fileSizeThreshold 文件上传数量限制
 * maxRequestSize 总大小限制
 */
@MultipartConfig(maxFileSize=1024*1024*10)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 解决乱码的设置，要尽量的靠前
		 */
		// 服务器接收中文数据乱码
		request.setCharacterEncoding("utf-8");
		// 服务器发送中文数据乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Part part = request.getPart("myfile"); // 获取问文件上传字段封装对象
		part.getSubmittedFileName();// 获取上传文件名
		part.getSize();				// 获取文件大小
		// headimgs 工程目录
		// String path = "E:/文件柜/91/YC91/C91-S2-Ply-javaee/WebContent/headimgs/";
		// headimgs tomcat 运行目录  发布目录
		//String path = "E:/dev/_tw6/.metadata/.plugins/org.eclipse.wst.server.core"
		//		+ "/tmp0/wtpwebapps/C91-S2-Ply-javaee/headimgs/";
		// getRealPath ==》 将 web 路径 转成 磁盘路径
		String path = request.getServletContext().getRealPath("/headimgs/");
		System.out.println(path);
		path += part.getSubmittedFileName();
		part.write(path);
		
		/**
		 * 定义
		 * 1. 值对象 （实体类==》数据库表）
		 * 2. Map集合 ==》 Gson将Map转成 json 对象 字符串 { msg:"", path:"" }
		 */
		Gson gson = new Gson();
		Map<String,String> data = new HashMap<>();
		data.put("msg", "file upload success!!!");
		data.put("path", "/headimgs/" + part.getSubmittedFileName());
		response.getWriter().append(gson.toJson(data));
	}

}
