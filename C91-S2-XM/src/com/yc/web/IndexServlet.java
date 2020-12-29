package com.yc.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.bean.Product;
import com.yc.dao.ProductDao;



@WebServlet("/index.s")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   ProductDao dao=new ProductDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list=null;
		try {
			list=dao.selectIndexYs();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		//list=>json  使用gson
		Gson gson =new Gson();
		String json=gson.toJson(list);
		//解决乱码问题
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
