package com.yc.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.bean.Category;
import com.yc.biz.CategoryBiz;



@WebServlet("/goodtype.action")
public class CategoryServlet extends BaseServlet88 {
	private static final long serialVersionUID = 1L;
       private CategoryBiz cDao=new CategoryBiz();
      

	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		try {
			List<Category> findall = cDao.findall();
			System.out.println(findall);
			response.getWriter().write(new Gson().toJson(findall));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
