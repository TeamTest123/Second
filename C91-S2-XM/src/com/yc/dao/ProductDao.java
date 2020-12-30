package com.yc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Product;
import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;


public class ProductDao {

	public List<Product>selectIndexYs() throws SQLException {
		String sql="select * from product limit 0,16";
		List<Product>list;
		list=DBHelper.selectList(sql, new ResultSetMapper<Product>() {

			@Override
			public Product map(ResultSet rs) throws SQLException {
				Product dm=new Product();
				dm.setPid(rs.getInt("pid"));
				dm.setProduct_type(rs.getString("product_type"));
				dm.setImage(rs.getString("image"));
				dm.setPname(rs.getString("pname"));
				dm.setPrice(rs.getString("price"));
				dm.setColor(rs.getString("color"));
				dm.setContent(rs.getString("content"));
				dm.setNumber(rs.getInt("number"));
				//其他字段请自行添加
				return dm;
			}
		});
		return  list;
		}
	
	public Product selectById(String id) throws SQLException {
		String sql="select * from product where pid=?";
		List<Product>list;
		list=DBHelper.selectList(sql, new ResultSetMapper<Product>() {

			@Override
			public Product map(ResultSet rs) throws SQLException {
				Product dm=new Product();
				dm.setPid(rs.getInt("pid"));
				dm.setProduct_type(rs.getString("product_type"));
				dm.setImage(rs.getString("image"));
				dm.setPname(rs.getString("pname"));
				dm.setPrice(rs.getString("price"));
				dm.setColor(rs.getString("color"));
				dm.setContent(rs.getString("content"));
				dm.setNumber(rs.getInt("number"));
				//其他字段请自行添加
				return dm;
			}
		},id);
		return  list.get(0);
		}
}
