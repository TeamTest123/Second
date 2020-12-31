package com.yc.dao;

import java.sql.SQLException;

import com.yc.bean.Cart;
import com.yc.util.DBHelper;

public class CartDao {

	public void insert(Cart cart) throws SQLException {
		String sql="insert into cart values(null,?,?,?)";
		DBHelper.updata(sql, 
				cart.getPid(),
				cart.getUid(),
				cart.getNumber());
	}
}
