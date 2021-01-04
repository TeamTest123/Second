package com.yc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yc.bean.Category;
import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;



public class fenDao {

	public List<Category>selectAllCategory() throws SQLException {
		String sql="select * from category where fid='0'";
		List<Category>list;
		list=DBHelper.selectList(sql, new ResultSetMapper<Category>() {

			@Override
			public Category map(ResultSet rs) throws SQLException {
				Category d=new Category();
				d.setSid(rs.getInt("sid"));
				d.setBname(rs.getString("bname"));
				d.setFid(rs.getInt("fid"));
				return d;
			}
		});
		return  list;
	}
	
	public List<Category>selectOne() throws SQLException {
		String sql="select * from category";
		List<Category>list;
		list=DBHelper.selectList(sql, new ResultSetMapper<Category>() {

			@Override
			public Category map(ResultSet rs) throws SQLException {
				Category d=new Category();
				d.setSid(rs.getInt("sid"));
				d.setBname(rs.getString("bname"));
				d.setFid(rs.getInt("fid"));
				return d;
			}
		});
		return  list;
	}


	public List<Map<String, Object>> listtypefen(String type,int page) throws SQLException{
		int begin =(page-1)*9;
		String sql="SELECT\n" +
				"	*\n" +
				"FROM\n" +
				"	product\n" +
				"WHERE\n" +
				"	product_type = ?\n" +
				"LIMIT ?,\n" +
				" 9";
		
		return DBHelper.selectListMap(sql,type,begin);
	}
	
	public int queryall(String type) throws SQLException{
		String sql="SELECT\n" +
				"	*\n" +
				"FROM\n" +
				"	(\n" +
				"		SELECT\n" +
				"			count(product_type) cnt,\n" +
				"			product_type\n" +
				"		FROM\n" +
				"			product\n" +
				"		GROUP BY\n" +
				"			product_type\n" +
				"	) c\n" +
				"WHERE\n" +
				"	c.product_type = ?";
		//return DBHelper.selectListMap(sql  );
		List<Integer> list=DBHelper.selectList(sql, new DBHelper.ResultSetMapper<Integer>() {

			@Override
			public Integer map(ResultSet rs) throws SQLException {
				
				return rs.getInt(1);
			}
		},type);
		return list.get(0);
		
	}
	

}
