package com.yc.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.biz.CategoryBiz;
import com.yc.dao.CategoryDao;
import com.yc.dao.ProductDao;

import web.BaseServlet;


@WebServlet("/Category.s")
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	private CategoryDao c=new CategoryDao();
	private ProductDao pd=new ProductDao();
	public void queryzuixing(HttpServletRequest request, HttpServletResponse response) throws IOException{
			try {
				write(response,c.querycnt());
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	/**
	 * 根据分类查询到具体的商品信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void querydetailgoods(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String producttype=request.getParameter("producttype");
		try {
			write(response,pd.selectByType(producttype));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	
}
	
}
