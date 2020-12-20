package com.yc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.User;
import com.yc.biz.BizException;
import com.yc.biz.UserBiz;

/*
 * 1、继承HttpServlet
 * 2、重写doGet,doPost
 * 3、配置xml +注解
 */

@WebServlet("/register.s")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private UserBiz ubiz=new UserBiz();
      
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		User user =new User();
		user.setUname(req.getParameter("uname"));
		user.setPhone(req.getParameter("phone"));
		user.setEmail(req.getParameter("email"));
		user.setAddress(req.getParameter("address"));
		user.setUpwd(req.getParameter("upwd"));
				
		try {
			ubiz.register(user);
			resp.getWriter().append("注册成功");
			
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().append("注册失败！原因："+e.getMessage());
		}
	
	}


}
