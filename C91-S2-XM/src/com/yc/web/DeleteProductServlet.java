package com.yc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yc.biz.ProductBiz;


@WebServlet("/DeleteProduct.s")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ProductBiz uBiz=new ProductBiz();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String pid=request.getParameter("pid");
		uBiz.delete(pid);
		response.getWriter().append("删除成功");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
