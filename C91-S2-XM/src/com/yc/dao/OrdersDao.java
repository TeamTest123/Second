package com.yc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
	
	private OrderMapper oMapper=new  OrderMapper();
	
	/*
	 * 分页查询订单
	 */
	public List<Orders> selectPage(int page) {
		// 计算开始页数
		int begin =(page-1)*10;
		// mysql分页查询语法:limit从第几行开始，查几行数据
		String sql = "select * from orders  limit ?,8";

		try {
			return DBHelper.selectList(sql, oMapper, begin);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 获取订单总记录数
	 * @throws SQLException 
	 */
	public int selectCount() {
		String sql ="select count(*) cnt from orders ";
		
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
	
	//用户实体对象属性映射类，因后续多次调用，所以单独建立一个类
		class OrderMapper implements ResultSetMapper<Orders>{

			@Override
			public Orders map(ResultSet rs) throws SQLException {
				Orders ss=new Orders();
				ss.setDid(rs.getInt("did"));
				ss.setUid(rs.getInt("uid"));
				ss.setMoney(rs.getString("money"));
				ss.setPay(rs.getString("pay"));
				ss.setOrder_status(rs.getString("order_status"));
				ss.setTime(rs.getString("time"));
					
					return ss;
			}
			
		}
		
		//修改订单状态
		public void  updateStatus(String order_status,Integer did) throws SQLException {
			String sql="update orders set order_status=? where did=?";
			
			DBHelper.update(sql,order_status,did);

		}
	
	
	
}
