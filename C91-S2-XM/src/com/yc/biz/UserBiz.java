package com.yc.biz;

import java.sql.SQLException;

import com.yc.bean.User;
import com.yc.dao.UserDao;


public class UserBiz {

	private UserDao udao=new UserDao();
	public void register(User user) throws BizException {
		//业务判断：同名判断，非空判断
		if(user.getUname()==null||user.getUname().isEmpty()) {
			throw new BizException("请填写您的用户名");
		}
		if(user.getUpwd()==null||user.getUpwd().isEmpty()) {
			throw new BizException("请填写您的密码");
		}
		if(user.getEmail()==null||user.getEmail().isEmpty()) {
			throw new BizException("请填写您的电子邮箱");
		}
		if(user.getAddress()==null||user.getAddress().isEmpty()) {
			throw new BizException("请填写您的收获地址");
		}
		if(user.getPhone()==null||user.getPhone().isEmpty()) {
			throw new BizException("请填写您的电话");
		}
		
		
		
		//判断当前用户名是否被注册
	try {
			int cnt =udao.countByName(user.getUname());
			if(cnt>0) {
				throw new BizException("该用户已被注册！请您重新输入用户名");
			}
			
			udao.insert(user);
		} catch (SQLException e) {
			//业务异常的信息是给用户查看的  异常转型==》异常链
			throw new BizException("系统繁忙，请稍后再试！！",e);
		}
		
		
	}
}
