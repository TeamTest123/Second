package com.yc.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.yc.bean.Cart;
import com.yc.bean.User;
import com.yc.dao.CartDao;


@WebServlet("/check.s")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private CartDao dao=new CartDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Cart cart =new Cart();
		HttpSession session = request.getSession();
		User u=(User) request.getSession().getAttribute("user");
		Integer uid=u.getUid();
		List<Cart> list=null;
		try {
			list=dao.selectAllCart(uid);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		//list=>json  使用gson
		Gson gson =new Gson();
		String json=gson.toJson(list);
		response.getWriter().append(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
