package com.yc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yc.bean.User;
import com.yc.biz.UserBiz;



@WebServlet("/CreateUser.s")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UserBiz uBiz=new UserBiz();
       
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		response.setContentType("text/html;charset=utf-8");
   		User ss=new User();
   		ss.setUname(request.getParameter("uname"));
   		ss.setAddress(request.getParameter("address"));
   		ss.setEmail(request.getParameter("email"));
   		ss.setPhone(request.getParameter("phone"));
   		
   		uBiz.create(ss);
   		response.getWriter().append("保存成功");
   	}

   	
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		
   		doGet(request, response);
   	}

   }

   