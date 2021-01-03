package com.yc.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.yc.bean.Product;
import com.yc.biz.ProductBiz;

@WebServlet("/productServlet.action")
@MultipartConfig
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductBiz pBiz = new ProductBiz();

	/**
	 * 后台添加商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		Product ss = new Product();
		ss.setProduct_type(request.getParameter("product_type"));
		//ss.setImage(request.getParameter("image"));
		ss.setPname(request.getParameter("pname"));
		ss.setPrice(request.getParameter("price"));
		ss.setColor(request.getParameter("color"));
		ss.setContent(request.getParameter("content"));
		ss.setNumber(request.getParameter("number"));
		String image=FileUpLoad(request, response);
		ss.setImage(image);
		try {
			pBiz.add(ss);
			response.getWriter().append("添加成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().append("添加失败");
		}
	}
	
	protected String FileUpLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Part p=request.getPart("img");
		String filename=p.getSubmittedFileName();
		String  webpath="/pic/"+filename;
		String realPath = request.getServletContext().getRealPath("/");
		String realPathParent=(new File(realPath)).getParent();
		String diskpath=realPathParent+webpath; 
		p.write(diskpath);
		return webpath;
//		//sc.getContextPath()获取当前工程名
//		webpath=sc.getContextPath()+webpath;
//		response.getWriter().append(webpath);
	}

}
