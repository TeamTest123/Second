package com.yc.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.bean.Cart;
import com.yc.bean.User;
import com.yc.biz.AddCartBiz;
import com.yc.biz.BizException;
import com.yc.biz.UpdateCartBiz;
import com.yc.dao.CartDao;

@WebServlet("/delete.s")
public class DeleteCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UpdateCartBiz ucd=new UpdateCartBiz();
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		updatecart(req, resp);
		
	}





	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(req, resp);
	}





	public  void updatecart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User u=(User) request.getSession().getAttribute("user");
		Integer uid=u.getUid();
		System.out.println();
		
		int pid= Integer.parseInt(request.getParameter("pid"));
		System.out.println(pid);		
			try {
				System.out.println("hahahha");
				ucd.delete(uid, pid);
				response.getWriter().append("删除成功");
			} catch (BizException | SQLException e) {
				response.getWriter().append("删除失败 原因："+e.getMessage());
			}
		
	}
}
