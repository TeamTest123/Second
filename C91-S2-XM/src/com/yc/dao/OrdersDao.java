package com.yc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public Object insert(Object uid,String money) throws SQLException {
		String sql="insert into orders (did,uid,money,pay,order_status,time)values (null,?,?,'支付宝','已付款',now()) ";
		Connection conn=DBHelper.getConnection();
		PreparedStatement ps=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setObject(1,uid );
		ps.setObject(2,money);
		ps.executeUpdate();
		ResultSet rs=ps.getGeneratedKeys();
		rs.next();
		return rs.getObject(1);
		
	}

	
	public void insertOrderdetail(Object uid,Object did)throws SQLException{
		String sql="INSERT INTO orders_detail SELECT\n" +
				"	NULL,\n" +
				"	?,\n" +
				"	a.pid,\n" +
				"	p.price,\n" +
				"	a.number\n" +
				"FROM\n" +
				"	cart a\n" +
				"JOIN product p ON a.pid = p.pid where uid =? ";
		DBHelper.update(sql,did,uid);
		
	}
}
