package com.yc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.yc.bean.User;
import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;


public class AdminDao {
	private AdminMapper userMapper=new AdminMapper();
	
	
	public List<User> Login(String uname,String upwd) throws SQLException{
		String sql="select * from user where uname=? and upwd=? and status=2 ";
		
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
	
	/*
	 * 管理员分页查询
	 */
	public List<User> selectPageadmin(int page) {
		// 计算开始页数
		int begin =(page-1)*10;
		// mysql分页查询语法:limit从第几行开始，查几行数据
		String sql = "select * from user where status=2 limit ?,10";

		try {
			return DBHelper.selectList(sql, userMapper, begin);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 管理员获取总记录数
	 * @throws SQLException 
	 */
	public int selectCountadmin() {
		String sql ="select count(*) cnt from user where status=2";
		
			try {
				List<Integer> list =DBHelper.selectList(sql,new ResultSetMapper<Integer>() {
					public Integer map(ResultSet rs) throws SQLException {
						return rs.getInt("cnt");
					}
		});
			return list.get(0);	
	}catch(SQLException e) {
		throw new RuntimeException(e);
	}
				
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
