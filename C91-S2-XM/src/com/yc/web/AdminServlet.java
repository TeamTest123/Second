
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
import com.yc.bean.User;
import com.yc.biz.BizException;
import com.yc.biz.LoginBiz;
import com.yc.biz.UserBiz;
import com.yc.dao.AdminDao;
import com.yc.dao.UserDao;


@WebServlet("/Manager.s")
public class AdminServlet extends BaseServlet88{
	private static final long serialVersionUID = 1L;
	
    UserBiz uBiz=new UserBiz(); 
    private UserDao uDao =new UserDao();
    LoginBiz lbiz=new LoginBiz();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		if("doLogin".equals(op)) {
			doLogin(request, response);
		}else if("checkpage".equals(op)) {
			checkpage(request,response);
		}
	}
	
	
	public void doLogin(HttpServletRequest request,HttpServletResponse response)
			throws IOException, ServletException{
		response.setContentType("text/html;charset=utf-8");
		
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		String op=request.getParameter("op");
		System.out.println(op);
		if(op!=null && op.equals("doPost")) {
			doCheck(request,response);
			return ;
		}
		
		try {
			
			User u=lbiz.AdminLogin(uname, upwd);
			response.getWriter().append("管理员登录成功");
			request.getSession().setAttribute("user", u);
		} catch (BizException e) {
			e.printStackTrace();
			response.getWriter().append("管理员登录失败！！！ 原因:"+e.getMessage());
		}
		
	}
	
	public void doCheck(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("docheck---------");
		//从session会话中获取登陆的用户信息
		User user=(User)request.getSession().getAttribute("user");
		System.out.println(user+"cfnhh");
//		Map<String, Object>map=null;
//		if(null!=user) {
//			Cart t=new Cart();
//			t.setUid(user.getUid());
//			map=CartDao.findByUid(t);
//		}
//		if(null==map) {
//			map=new HashMap<String, Object>();
//		}
//		
//		map.put("user", user);
		printJSon(user, response);
		
	}
    
	
    
    
    //查看页数
    public void checkpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");
		
		String page=request.getParameter("page");
		
		int iPage = page ==null ? 1: Integer.parseInt(page);
		AdminDao aDao=new AdminDao();
		List<User> rows = aDao.selectPageadmin(iPage);
		int total=aDao.selectCountadmin();
		
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
