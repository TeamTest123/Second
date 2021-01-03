package com.yc.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yc.biz.BizException;
import com.yc.dao.UpdateNumDao;

@WebServlet("/num.s")
public class UpdataNumServlet extends BaseServlet88  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UpdateNumDao dao=new UpdateNumDao();
	public  void updatenum(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, BizException {
		
		
		int pid= Integer.parseInt(request.getParameter("pid"));
		System.out.println(pid);		
			dao.updateproduct(pid);
	}
}
