package com.yc.biz;

import java.sql.SQLException;
import java.util.List;
import com.yc.bean.User;
import com.yc.dao.AdminDao;
import com.yc.dao.LoginDAO;


public class LoginBiz {
	

	public User BoardLogin(String uname,String upwd) throws BizException {
		if (uname == null || uname.trim().isEmpty()) {
			throw new BizException("用户名或密码不能为空");
		}
		if (upwd == null || upwd.trim().isEmpty()) {
			throw new BizException("密码不能为空");
		}
		try {
			LoginDAO ld =new LoginDAO();
			List<User> list = ld.Login(uname, upwd);
			if (list.size() == 0) {
				throw new BizException("用户名或密码错误");
			}
			System.out.println(list.get(0));
			return list.get(0);
		} catch (SQLException e) {
			throw new BizException("系统繁忙 请联系管理员");
		}
	}
	
	public User AdminLogin(String uname,String upwd) throws BizException {
		if (uname == null || uname.trim().isEmpty()) {
			throw new BizException("用户名或密码不能为空");
		}
		if (upwd == null || upwd.trim().isEmpty()) {
			throw new BizException("密码不能为空");
		}
		try {
			AdminDao ld =new AdminDao();
			List<User> list = ld.Login(uname, upwd);
			if (list.size() == 0) {
				throw new BizException("用户名或密码错误");
			}
			System.out.println(list.get(0));
			return list.get(0);
		} catch (SQLException e) {
			throw new BizException("系统繁忙 请联系管理员");
		}
	}

}
