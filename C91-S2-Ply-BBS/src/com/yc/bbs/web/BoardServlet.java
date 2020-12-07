package com.yc.bbs.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bbs.dao.BoardDao;
import com.yc.common.web.BaseServlet;

@WebServlet("/board.s")
public class BoardServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BoardDao bdao = new BoardDao();
	
	public void query(HttpServletRequest request, HttpServletResponse response) throws IOException{
		write(response, bdao.query());
	}

}
