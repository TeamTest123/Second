package com.yc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.yc.bean.User;
import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;


public class AdminDao {
	public List<User> Login(String uname,String upwd) throws SQLException{
		String sql="select uname,upwd from user where status=2 ";
		
		return DBHelper.selectList(sql, new ResultSetMapper<User>() {

			@Override
			public User map(ResultSet rs) throws SQLException {
				User a=new User();
				a.setUname(rs.getString("uname"));
				
				a.setUpwd(rs.getString("upwd"));
				
				return a;
			}
		
		}, uname,upwd);
	}

	//用户实体对象属性映射类，因后续多次调用，所以单独建立一个类
	class AdminMapper implements ResultSetMapper<User>{

		@Override
		public User map(ResultSet rs) throws SQLException {
			User vv=new User();
			vv.setUid(rs.getInt("uid"));
			vv.setUname(rs.getString("uname"));
			
				
				return vv;
		}
	}

	
		

}
