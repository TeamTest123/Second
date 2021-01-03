package com.yc.web;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.bean.User;
import com.yc.biz.BizException;
import com.yc.biz.UpdateCartBiz;
import com.yc.dao.CartDao;

@WebServlet("/cart.s")
public class Updatecart extends BaseServlet88 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UpdateCartBiz ucd=new UpdateCartBiz();
	
	
	
	
	
	public  void updatecart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User u=(User) request.getSession().getAttribute("user");
		System.out.println(u+"yonghua");
		Integer uid=u.getUid();
		
		int pid=Integer.parseInt(request.getParameter("pid"));
				
			try {
				ucd.Updatecart(uid, pid);
				write(response, "添加成功");
			} catch (BizException e) {
				write(response, "添加失败 原因："+e.getMessage());
			}
		
	}
	

	private CartDao cd=new CartDao();
	public  void getcnt(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		HttpSession session = request.getSession();
		User u=(User) request.getSession().getAttribute("user");
		Integer uid=u.getUid();
		String pid=request.getParameter("pid");
		int pids=Integer.parseInt(pid);
		System.out.println(pid+"-----"+uid);
		try {
			
			write(response, cd.querycnt(uid, pids));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}