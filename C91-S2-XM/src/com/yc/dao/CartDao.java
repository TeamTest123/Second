package com.yc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Cart;
import com.yc.bean.Category;
import com.yc.bean.Product;
import com.yc.bean.User;
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
	
	public List<Cart>selectAllCategory() throws SQLException {
		String sql="\"SELECT\\n\" +\r\n"
				+ "\"	p.pname,p.color,p.price,c.number,p.image,uid\\n\" +\r\n"
				+ "\"FROM\\n\" +\r\n"
				+ "\"	cart c\\n\" +\r\n"
				+ "\"LEFT JOIN product p ON c.pid = p.pid\\n\" +\r\n"
				+ "\" where uid in(\\n\" +\r\n"
				+ "\"SELECT\\n\" +\r\n"
				+ "\"	u.uid\\n\" +\r\n"
				+ "\"FROM\\n\" +\r\n"
				+ "\"	cart a\\n\" +\r\n"
				+ "\"LEFT JOIN user u ON a.uid = u.uid);\"";
		List<Cart>list;
		list=DBHelper.selectList(sql, new ResultSetMapper<Cart>() {

			@Override
			public Cart map(ResultSet rs) throws SQLException {
				Cart c=new Cart();
				Product p=new Product();
				User u=new User();
//				p.setPname(rs.getString("pname"));
//				p.setColor(rs.getString("color"));
//				p.setPrice(rs.getString("price"));
				c.setNumber(rs.getInt("number"));
//				p.setImage(rs.getString("image"));
//				u.setUid(rs.getInt("uid"));
				return c;
			
			}
		});
		return  list;
	}
	
}
