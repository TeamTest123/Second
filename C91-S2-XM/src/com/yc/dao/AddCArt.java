package com.yc.dao;

import java.sql.SQLException;

import com.yc.bean.User;
import com.yc.util.DBHelper;

public class AddCArt {

	public void insert(User user) throws SQLException {
		String sql="insert into cart values(null,?,?,?,?)";
		DBHelper.updata(sql, 
				user.getUname(),
				user.getUpwd(),
				user.getPhone(),
				user.getEmail(),
				user.getAddress());
	}
}
