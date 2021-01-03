package com.yc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.yc.util.Utils;


public class BaseServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	private Gson gson=new Gson();

	@Override
	protected void doPost(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
	  doGet(request, response);
	}
	
	public void setCharacterEncoding(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}
	
	protected void printJSon(HttpServletResponse response,int i,String msg ) throws ServletException, IOException {
		  Map<String, Object> map=new HashMap<String, Object>();
		  map.put("code", i);
		  map.put("msg", msg);
		  Gson gson =new Gson();
		  String info =gson.toJson(map);
		  PrintWriter out =response.getWriter();
		  out.print(info);
	}
	
	protected void printJSon(Object obj , HttpServletResponse response ) throws ServletException, IOException {
		  Gson gson =new Gson();
		  String info =gson.toJson(obj);
		  PrintWriter out =response.getWriter();
		  out.print(info);
		}
	
	//输出错误信息
	public void printError(HttpServletResponse response) throws IOException{
		response.setHeader("Content-Type", "text/html");
		response.getWriter().print("<script>window.location.href='error.html';</script>");
	}
	
	public <T> T  parseRequest(HttpServletRequest request,Class<T> cls) throws Exception{
		T t=null;
		//通过Class实例对象获取   字段和方法
		Field[]fileds =cls.getDeclaredFields();
		Method [] methods =cls.getDeclaredMethods();
		//创建对象
		t =cls.newInstance(); //底层调用无参数函数
		String fname =null;
		String mname=null;
		String typename=null;
		for(Field f:fileds){
			fname=f.getName();
			String info =request.getParameter(fname);
			//判断是否为空
			if(!Utils.doCheckNotNull(info)){
				continue;
			}
			for(Method m:methods){
				 mname=m.getName();
				//循环所有列
			
					if(("set"+fname).equalsIgnoreCase(mname)){
						//获取形参类型
						String typeName =m.getParameterTypes()[0].getName();
						if("java.lang.Integer".equals(typeName)||"int".equals(typeName)){
							m.invoke(t, Integer.parseInt(info));
						}else if("java.lang.Double".equals(typeName)||"double".equals(typeName)){
							m.invoke(t, Double.parseDouble(info));
						}else if("java.lang.Float".equals(typeName)||"float".equals(typeName)){
							m.invoke(t, Float.parseFloat(info));
						}else if("java.lang.Long".equals(typeName)||"long".equals(typeName)){
							m.invoke(t, Long.parseLong(info));
						}else if("java.lang.String".equals(typeName)){
							m.invoke(t, info);
						}else{
							
						}
					}
				
			}
			
		}
		return t;
		
	}
	
	public void write(HttpServletResponse response, Object obj) throws IOException {
		String json = gson.toJson(obj);
		response.getWriter().append(json);
	}

}
