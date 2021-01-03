package com.yc.biz;


import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Category;
import com.yc.dao.CategoryDao;

public class CategoryBiz {
	CategoryDao cDao=new CategoryDao();
	
	public List<Category> findall() throws SQLException{
		
		return cDao.findall();
	}

}
