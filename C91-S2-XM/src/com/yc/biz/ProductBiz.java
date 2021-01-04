package com.yc.biz;

import java.sql.SQLException;
import com.yc.bean.Product;
import com.yc.dao.ProductDao;


public class ProductBiz {
	
	private ProductDao pDao=new ProductDao();
	
	public void delete(String  pid) {
		
		if(pid==null) {
			
		}
		
		try {
			pDao.deleteByPid(Integer.parseInt(pid));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 新加用户
	 * @param ss
	 * @return 
	 * @throws Exception 
	 */
	public void add(Product bean) throws Exception {
		if(bean.getPname()==null) {
			
		}
		try {
			pDao.add(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}



}
