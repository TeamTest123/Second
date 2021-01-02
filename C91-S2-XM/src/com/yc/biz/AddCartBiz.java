package com.yc.biz;

import com.yc.bean.Cart;
import com.yc.dao.CartDao;

public class AddCartBiz {

	private CartDao dao=new CartDao();
	public void add(Cart cart) throws BizException {
		
		if(cart.getUid()==null||cart.getUid()==null) {
			throw new BizException("请登录后再操作");
		}
	}
}
