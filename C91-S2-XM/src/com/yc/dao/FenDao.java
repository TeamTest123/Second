package com.yc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Category;
import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;



public class FenDao {

	public List<Category>selectAllCategory() throws SQLException {
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
	
}
