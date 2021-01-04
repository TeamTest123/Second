package com.yc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.bean.Orders;
import com.yc.bean.User;
import com.yc.biz.BizException;
import com.yc.biz.OrderBiz;

@WebServlet("/addorder.s")
public class AddOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private OrderBiz biz=new OrderBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Orders orders =new Orders();
		HttpSession session = request.getSession();
		User u=(User) request.getSession().getAttribute("user");
		Integer uid=u.getUid();
		try {
			orders.setUid(uid);
		    biz.create(orders);
		    response.getWriter().append("提交订单成功");
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
