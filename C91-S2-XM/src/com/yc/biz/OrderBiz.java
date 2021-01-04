package com.yc.biz;

import java.sql.SQLException;

import com.yc.dao.CartDao;
import com.yc.dao.OrdersDao;

public class OrderBiz {

	//创建订单
	private OrdersDao odao=new OrdersDao();
	private CartDao cdao=new CartDao();
	public void create(Object uid) throws BizException {
		
		try {
			Object did=odao.insert(uid);
			odao.insertOrderdetail(uid, did);
			cdao.deleteByuid(uid);
		} catch (SQLException e) {
			throw new BizException("提交订单失败！！！",e);
		}
		
	}
	
	public static void main(String[] args) throws BizException {
		OrderBiz obiz=new OrderBiz();
		obiz.create(4);
	}
}
