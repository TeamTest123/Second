package com.yc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Admin;
import com.yc.bean.User;
import com.yc.biz.BizException;

import yc.login.LoginBiz;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginBiz adm=new LoginBiz();
	public void doPost (HttpServletRequest request,HttpServletResponse response)
			throws IOException{
		response.setContentType("text/html;charset=utf-8");
		
		String adname=request.getParameter("adname");
		String adpwd=request.getParameter("adpwd");
		
		try {
			
			Admin a=adm.AdminLogin(adname, adpwd);
			response.getWriter().append("管理员登录成功");
			request.getSession().setAttribute("admin", a);
		} catch (BizException e) {
			e.printStackTrace();
			response.getWriter().append("登录失败了！！！ 原因:"+e.getMessage());
		}
		
	}

}
