
package com.yc.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.yc.bean.Admin;
import com.yc.bean.User;
import com.yc.biz.BizException;
import com.yc.biz.UserBiz;
import com.yc.dao.UserDao;
import yc.login.LoginBiz;


@WebServlet("/Manager.s")
public class AdminServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	
    UserBiz uBiz=new UserBiz(); 
    private LoginBiz adm=new LoginBiz();
    private UserDao uDao =new UserDao();
//    //删除管理员      管理员能不能删掉？待定
//    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
//		
//		String uid=request.getParameter("uid");
//		uBiz.delete(uid);
//		response.getWriter().append("删除管理员成功");
//	}
//    
    //查看页数
    public void checkpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
    //查看总数
    public void checkcount(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		
		response.getWriter().append(""+uDao.selectCount());
	}

	

    
    
}

