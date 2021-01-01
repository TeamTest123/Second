package com.yc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Cart;

import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;

public class CartDao {

	public void insert(Cart cart) throws SQLException {
		String sql="insert into cart values(null,?,?,?)";
		DBHelper.update(sql, 
				cart.getPid(),
				cart.getUid(),
				cart.getNumber());
	}
	
	public List<Cart>selectAllCart() throws SQLException {
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
				"	uid IN (\n" +
				"		SELECT\n" +
				"			u.uid\n" +
				"		FROM\n" +
				"			cart a\n" +
				"		LEFT JOIN user u ON a.uid = u.uid\n" +
				"	)";
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
				c.setUid(rs.getInt("uid"));
				return c;
			
			}
		});
		return  list;
	}
	
}
