package com.yc.web;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yc.bean.Product;
import com.yc.biz.ProductBiz;
import com.yc.util.FileUploadUtil;
import com.yc.util.LogUtil;


@WebServlet("/product.s")
public class ProFileUploadServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   private ProductBiz pBiz=new ProductBiz();
   
	
	protected void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//解析请求对象  文件上传
		
		try {
			Product bean=FileUploadUtil.parseRequest(request, Product.class);
			//调用业务层代码
			pBiz.add(bean);
			printJson(response,1,null);
			
		} catch (Exception e) {
			LogUtil.log.error("商品信息文件上传异常！"+e.getMessage());
			printJson(response,0,null);
		}
		
	}






}
