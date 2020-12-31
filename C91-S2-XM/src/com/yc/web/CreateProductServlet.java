package com.yc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Product;
import com.yc.bean.User;
import com.yc.biz.ProductBiz;


@WebServlet("/CreateProduct.s")
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  private ProductBiz pBiz=new ProductBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
   		Product ss=new  Product();
   		ss.setProduct_type(request.getParameter("product_type"));
   		ss.setImage(request.getParameter("image"));
   		ss.setPname(request.getParameter("pname"));
   		ss.setPrice(request.getParameter("price"));
   		ss.setColor(request.getParameter("Color"));
   		ss.setContent(request.getParameter("content"));
   		ss.setNumber(request.getParameter("number"));
   		
   		try {
			pBiz.add(ss);
			response.getWriter().append("保存成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().append("保存失败");
		}
   		
   	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
