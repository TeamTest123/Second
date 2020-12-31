package com.yc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.UserDao;


@WebServlet("/QueryCountUser.s")
public class QueryCountUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserDao uDao =new UserDao();
	
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		
		response.getWriter().append(""+uDao.selectCount());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
