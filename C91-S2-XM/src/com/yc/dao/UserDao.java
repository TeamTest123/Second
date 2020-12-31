package com.yc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.bean.User;
import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;



public class UserDao {

	public void insert(User user) throws SQLException {
		String sql="insert into user values(null,?,?,?,?,?,?)";
		DBHelper.updata(sql, 
				user.getUname(),
				user.getUpwd(),
				user.getPhone(),
				user.getEmail(),
				user.getAddress(),
				user.getStatus());
	}
	
	//查询是否有重名用户
	public int countByName(String uname) throws SQLException {
		String sql="select count(*) from user where uname=?";
		List<Integer> list=DBHelper.selectList(sql, new ResultSetMapper<Integer>() {
			public Integer map(ResultSet rs) throws SQLException {
				return rs.getInt(1);
			}
		}, uname);
		return list.get(0);
	}
}
