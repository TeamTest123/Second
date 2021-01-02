package com.yc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Product;
import com.yc.biz.ProductBiz;


@WebServlet("/productServlet.action")
public class productServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	 private ProductBiz pBiz=new ProductBiz();
	 /**
	  * 后台添加商品
	  * @param request
	  * @param response
	  * @throws ServletException
	  * @throws IOException
	  */
		protected void AddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
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
		
		/**
		 *后台 删除商品
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
	   		protected void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   			response.setContentType("text/html;charset=utf-8");

	   			String  pid=request.getParameter("pid");
	   			pBiz.delete(pid);
	   			response.getWriter().append("删除成功");

	   		}
	   		
	   	
		}

		
    