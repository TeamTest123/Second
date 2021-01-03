package com.yc.biz;

import java.sql.SQLException;

import com.yc.dao.CartDao;

public class UpdateCartBiz {

	 	private CartDao cd=new CartDao();
		public void Updatecart(int uid,int pid) throws BizException {
			try {
				if(cd.querycnt(uid, pid)>=1) {
					cd.updateproduct(uid,pid);
				}
			} catch (SQLException e) {
				throw new BizException("系统繁忙 请稍后再试");
			}
		}
		
		public void jian(int uid,int pid) throws BizException, SQLException {
			try {
				if(cd.querycnt(uid, pid)>0) {
					cd.jian(uid,pid);
				}
			} catch (SQLException e) {
				
				throw new BizException("系统繁忙 请稍后再试");
			}
		}
		public int delete(int uid,int pid) throws BizException, SQLException {
			try {
				int t=cd.delete(uid, pid);
				System.out.println(t+"----");
				return t;
			} catch (SQLException e) {
				throw new BizException("系统繁忙 请稍后再试");
			}
		}
}
