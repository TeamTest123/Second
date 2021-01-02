package com.yc.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yc.bean.Cart;
import com.yc.bean.User;
import com.yc.biz.BizException;
import com.yc.dao.CartDao;

import yc.login.LoginBiz;


@WebServlet("/loginUser.s")
public class UserServlet extends BaseServlet {
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
	
	public void doCheck(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("docheck---------");
		//从session会话中获取登陆的用户信息
		User user=(User)request.getSession().getAttribute("user");
		Map<String, Object>map=null;
		if(null!=user) {
			Cart t=new Cart();
			t.setUid(user.getUid());
			map=CartDao.findByUid(t);
		}
		if(null==map) {
			map=new HashMap<String, Object>();
		}
		
		map.put("user", user);
		printJSon(map, response);
		
	}
    
	

}
