package com.yc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Category;
import com.yc.bean.Orders;
import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;

public class OrdersDao {

	public List<Orders>selectOne() throws SQLException {
		String sql="SELECT\n" +
				"	o.did,\n" +
				"	u.uid,\n" +
				"	o.money,\n" +
				"	o.pay,\n" +
				"	o.order_status,\n" +
				"	o.time\n" +
				"FROM\n" +
				"	orders o\n" +
				"LEFT JOIN user u ON o.uid = u.uid";
		List<Orders>list;
		list=DBHelper.selectList(sql, new ResultSetMapper<Orders>() {

			@Override
			public Orders map(ResultSet rs) throws SQLException {
				Orders d=new Orders();
				
				d.setDid(rs.getInt("did"));
				d.setUid(rs.getInt("uid"));
				d.setMoney(rs.getString("money"));
				d.setPay(rs.getString("pay"));
				d.setOrder_status(rs.getString("order_status"));
				d.setTime(rs.getString("time"));
				
				return d;
			}
		});
		return  list;
	}
}
