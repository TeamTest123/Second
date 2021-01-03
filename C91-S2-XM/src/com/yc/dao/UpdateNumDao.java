package com.yc.dao;

import java.sql.SQLException;

import com.yc.util.DBHelper;

public class UpdateNumDao {

	public void updateproduct(int pid) throws SQLException {
		String sql="update product set number=number-1 where pid=?";
		DBHelper dbh=new DBHelper();
		dbh.update(sql, pid);
	}
}
