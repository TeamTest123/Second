package com.yc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.yc.bean.Product;
import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;

public class ProductDao {

	public List<Product>selectIndexYs() throws SQLException {
		String sql="select * from product limit 0,9";
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
				
				return dm;
			}
		},id);
		return  list.get(0);
		}
	
	public List<Product> selectByType(String product_type) throws SQLException {
		String sql="select * from product where product_type=?";
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
				
				return dm;
			}
		},product_type);
		return  list;
		}
	
	/**
	 * 后台分页查询
	 * @return
	 */
	//产品实体对象属性映射对象
	private ProMapper pMapper=new ProMapper();
	public List<Product> selectPage(int page) {
		// 计算开始页数
		int begin =(page-1)*10;
		// mysql分页查询语法:limit从第几行开始，查几行数据
		String sql = "select * from product limit ?,10";

		try {
			return DBHelper.selectList(sql, pMapper, begin);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	class ProMapper implements ResultSetMapper<Product>{

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
			
			return dm;
		}
	}
	
	/**
	 * 后台获取总记录数
	 * @throws SQLException 
	 */
	public int selectCount() {
		String sql ="select count(*) cnt from product";
		
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

	/**
	 * 删除商品
	 * @param pid
	 * @throws SQLException
	 */
	public void deleteByPid(Integer pid) throws SQLException {
		DBHelper dbh=new DBHelper();
		String sql="delete from product where pid=?";
		dbh.update(sql,pid);
	}

	/**
	 * 添加商品
	 * @param pp
	 * @throws SQLException 
	 */
	//添加商品信息
		public int add(Product pp) throws Exception {
			String sql="insert into product values(null,?,?,?,?,?,?,?)";
			return DBHelper.update(sql,
					pp.getProduct_type(),
					pp.getImage(),
					pp.getPname(),
					pp.getPrice(),
					pp.getColor(),
					pp.getContent(),
					pp.getNumber());
		}



	
}
	