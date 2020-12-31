package com.yc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.yc.bean.User;
import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;

public class UserDao {
	
	private UserMapper userMapper=new UserMapper();

	/*
	 * 分页查询
	 */
	public List<User> selectPage(int page) {
		// 计算开始页数
		int begin =(page-1)*10;
		// mysql分页查询语法:limit从第几行开始，查几行数据
		String sql = "select * from user limit ?,10";

		try {
			return DBHelper.selectList(sql, userMapper, begin);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 获取总记录数
	 * @throws SQLException 
	 */
	public int selectCount() {
		String sql ="select count(*) cnt from user";
		
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
	
	/*
	 * 删除用户
	 */
	public void deleteByUid(Integer uid) throws SQLException {
		DBHelper dbh=new DBHelper();
		String sql="delete from user where uid=?";
		dbh.update(sql,uid);
	}
	
	
	public void insert(User user) throws SQLException {
		String sql="insert into user values(null,?,?,?,?,?)";
		DBHelper.update(sql, 
				user.getUname(),
				user.getUpwd(),
				user.getPhone(),
				user.getEmail(),
				user.getAddress());
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
	
	//用户实体对象属性映射类，因后续多次调用，所以单独建立一个类
	class UserMapper implements ResultSetMapper<User>{

		@Override
		public User map(ResultSet rs) throws SQLException {
			User ss=new User();
			ss.setUid(rs.getInt("uid"));
			ss.setUname(rs.getString("uname"));
			ss.setPhone(rs.getString("phone"));
			ss.setEmail(rs.getString("email"));
			ss.setAddress(rs.getString("address"));
				
				return ss;
		}
		
	}

}
