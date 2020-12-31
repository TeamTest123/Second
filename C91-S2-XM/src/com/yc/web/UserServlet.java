package com.yc.web;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.yc.bean.User;
import com.yc.biz.BizException;
import yc.login.LoginBiz;


@WebServlet("/loginUser.s")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LoginBiz lBiz=new LoginBiz();
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException{
		response.setContentType("text/html;charset=utf-8");
		
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		
		try {
			
			User u=lBiz.BoardLogin(uname, upwd);
			response.getWriter().append("登陆成功");
			request.getSession().setAttribute("user", u);
		} catch (BizException e) {
			e.printStackTrace();
			response.getWriter().append("登录失败！！！ 原因:"+e.getMessage());
		}
		
	}
    
	

}
