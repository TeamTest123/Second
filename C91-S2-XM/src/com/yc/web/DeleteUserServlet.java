package com.yc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.biz.UserBiz;

@WebServlet("/DeleteUser.s")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserBiz uBiz=new UserBiz();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String uid=request.getParameter("uid");
		uBiz.delete(uid);
		response.getWriter().append("删除成功");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
