package com.yc.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.yc.bean.User;
import com.yc.dao.UserDao;



@WebServlet("/QueryPageUser.s")
public class QueryPageUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private UserDao uDao =new UserDao();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=utf-8");
		
		String page=request.getParameter("page");
		
		int iPage = page ==null ? 1: Integer.parseInt(page);
		
		List<User> rows = uDao.selectPage(iPage);
		int total=uDao.selectCount();
		
		Map<String, Object>data=new HashMap<>();
		data.put("rows", rows);
		data.put("total", total);
		
		//数据如何发送给浏览器?
		//JSON
		//JSON格式
		//[ {"id":1,"name":"yc",....},{},{}    ]
		String json=new Gson().toJson(data);
		System.out.println(json);
		response.getWriter().append(json);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
