package com.yc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Category;
import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;

public class CategoryDao {
	//查询是否有重名分类
	public int countByName(String bname) throws SQLException {
		String sql="select count(*) from category where bname=?";
		List<Integer> list=DBHelper.selectList(sql, new ResultSetMapper<Integer>() {
			public Integer map(ResultSet rs) throws SQLException {
				return rs.getInt(1);
			}
		}, bname);
		return list.get(0);
	}

	/**
	 * 获取总分类数
	 * @throws SQLException 
	 */
	public int selectCount() {
		String sql ="select count(*) cnt from category";
		
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
	
//	//查看所有分类
//	public List<Category> findall(){
//		String sql="select sid,bname,fid from category";
//
//		return DBHelper.findMutipl(sql, null,Category.class);
//	
//	
//	
//	
//	}
	
	
	
	class CategoryMapper  implements ResultSetMapper<Category>{

		@Override
		public Category map(ResultSet rs) throws SQLException {
			Category category=new Category();
			category.setSid(rs.getInt("sid"));
			category.setBname(rs.getString("bname"));
			category.setFid(rs.getInt("fid"));
			
			
			return category;
		}
		
		
		
	}
}
