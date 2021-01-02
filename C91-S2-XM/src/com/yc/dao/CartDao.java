package com.yc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yc.bean.Cart;

import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;

public class CartDao {
	
	
	
	
	

	public void insert(Cart cart) throws SQLException {
		String sql1="";
		String sql="insert into cart values(null,?,?,?)";
		DBHelper.update(sql, 
				cart.getPid(),
				cart.getUid(),
				cart.getNumber());
		
		
	}
	
	public List<Cart>selectAllCart(Integer uid) throws SQLException {
		String sql="SELECT\n" +
				"	p.pname,\n" +
				"	p.color,\n" +
				"	p.price,\n" +
				"	c.number,\n" +
				"	p.image,\n" +
				"	uid\n" +
				"FROM\n" +
				"	cart c\n" +
				"LEFT JOIN product p ON c.pid = p.pid\n" +
				"WHERE\n" +
				"	uid =?";
		List<Cart>list;
		list=DBHelper.selectList(sql, new ResultSetMapper<Cart>() {

			@Override
			public Cart map(ResultSet rs) throws SQLException {
				Cart c=new Cart();
				
				c.setPname(rs.getString("pname"));
				c.setColor(rs.getString("color"));
				c.setPrice(rs.getString("price"));
				c.setNumber(rs.getInt("number"));
				c.setImage(rs.getString("image"));
				return c;
			
			}
		},uid);
		return  list;
	}
	
	public int querycnt(int uid,int pid) throws SQLException {
		String sql="SELECT\n" +
				"	count(pid) cnt\n" +
				"FROM\n" +
				"	cart\n" +
				"WHERE\n" +
				"	uid = ?\n" +
				"AND pid = ?";
		DBHelper dbh=new DBHelper();
		List<Integer> list=dbh.selectList(sql, new  ResultSetMapper<Integer>() {

			@Override
			public Integer map(ResultSet rs) throws SQLException {
				
				return rs.getInt(1);
			}
		}, uid,pid);
		return list.get(0);
	}
	
	
	public void updateproduct(int uid,int pid) throws SQLException {
		String sql="UPDATE cart set number=number+1 where pid=? and uid=?";
		DBHelper dbh=new DBHelper();
		dbh.update(sql, pid,uid);
	}
	
	
}
