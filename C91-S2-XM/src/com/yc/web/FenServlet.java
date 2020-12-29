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
import com.yc.bean.Category;
import com.yc.dao.FenDao;


/**
 * Servlet implementation class FenServlet
 */
@WebServlet("/fen.s")
public class FenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private FenDao fdao=new FenDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> list=null;
		try {
			list=fdao.selectAllCategory();
			
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
