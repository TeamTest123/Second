package com.yc.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.fenDao;




@WebServlet("/fen.ss")
public class CategoryFenServlet extends web.BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private fenDao fd=new fenDao();
	public void querycnt(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String type=request.getParameter("type");
		try {
			write(response, fd.queryall(type));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void querysinger(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String category=request.getParameter("category");
		String page=request.getParameter("page");
		int ipage=page .equals("undefined")? 1:Integer.parseInt(page);
		try {
			write(response, fd.listtypefen(category, ipage));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
}
