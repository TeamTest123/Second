package com.yc.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.bean.Cart;
import com.yc.bean.User;
import com.yc.dao.CartDao;



@WebServlet("/add.s")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDao dao=new CartDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cart cart =new Cart();
		HttpSession session = request.getSession();
		User u=(User) request.getSession().getAttribute("user");
		Integer uid=u.getUid();
		String  pid=request.getParameter("pid");
		String number=request.getParameter("number");
		
		try {
			cart.setPid(Integer.valueOf(pid));
			cart.setUid(uid);
			cart.setNumber(Integer.valueOf(number));
		    dao.insert(cart);
		    response.getWriter().append("添加成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().append("添加失败！原因："+e.getMessage());
		}			
	

	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String pid=request.getParameter("pid");
		
		doGet(request, response);
	}

}
