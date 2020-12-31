package com.yc.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.yc.bean.Cart;
import com.yc.bean.Category;
import com.yc.bean.User;
import com.yc.dao.CartDao;



@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDao dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cart cart =new Cart();
		HttpSession session = request.getSession();
		User u=(User) request.getSession().getAttribute("user");
		Integer uid=u.getUid();
		String  pid=request.getParameter("pid");
		String number=request.getParameter("number");
		Cart list=null;
		try {
			cart.setPid(Integer.valueOf(pid));
			cart.setUid(uid);
			cart.setNumber(Integer.valueOf(number));
			dao.insert(cart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		List<Cart> list=null;
//		list=dao.insert(cart);
//		Gson gson =new Gson();
//		String json=gson.toJson(list);
//		response.getWriter().append(json);
//				
	

	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
