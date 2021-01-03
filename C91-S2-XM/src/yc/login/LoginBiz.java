package yc.login;

import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Admin;
import com.yc.bean.User;
import com.yc.biz.BizException;

public class LoginBiz {
	private LoginDAO ld =new LoginDAO();
	private AdminDao ad =new AdminDao();
	public User BoardLogin(String uname,String upwd) throws BizException {
		if (uname == null || uname.trim().isEmpty()) {
			throw new BizException("用户名或密码不能为空");
		}
		if (upwd == null || upwd.trim().isEmpty()) {
			throw new BizException("密码不能为空");
		}
		try {
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
	
	public Admin AdminLogin(String adname,String adpwd) throws BizException {
		if (adname == null || adname.trim().isEmpty()) {
			throw new BizException("用户名或密码不能为空");
		}
		if (adpwd == null || adpwd.trim().isEmpty()) {
			throw new BizException("密码不能为空");
		}
		try {
			List<Admin> list = ad.Login(adname, adpwd);
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
