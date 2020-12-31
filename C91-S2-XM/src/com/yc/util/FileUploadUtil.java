package com.yc.util;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * 文件上传的工具类 
 * @author 超超超
 *
 */
public class FileUploadUtil {

	private static final  String  IMAGEPATH="../pro-images/";
	private static final  String  CHARSET="UTF-8";
 
	
	/**
	 * 文件上传
	 * @param request
	 * @param t
	 * @return
	 * @throws FileUploadException
	 * @throws Exception 
	 * @throws  
	 */
	public static <T> T parseRequest(HttpServletRequest request,Class<T> cls) throws  Exception{
		//Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		//解析请求对象  
		// Parse the request
		List<FileItem> items = upload.parseRequest(request);
		//创建T对象  
		T  t  = cls.newInstance();
		Method []methods = cls.getDeclaredMethods();
		System.out.println(items.size()+"---------");
		//循环文件项 
		for(FileItem  item:items){
			if(item.isFormField()){
				//获取表单元素的name值 
				String name =item.getFieldName();  //传入表单元素的名称必须和实体类中字段名一致 
				//获取表单元素的value值 
				String value =item.getString(CHARSET);
				for(Method m:methods){
					if(("set"+name).equalsIgnoreCase(m.getName())){
						String typeName =m.getParameterTypes()[0].getName();//获取set方法的形参的数据类型  
						if("java.lang.Integer".equals(typeName)  || "int".equals(typeName)){
							m.invoke(t, Integer.parseInt(value));
						}else if("java.lang.Double".equals(typeName) || "double".equals(typeName)){
							m.invoke(t, Double.parseDouble(value));
						}else if("java.lang.Float".equals(typeName) || "float".equals(typeName)){
							m.invoke(t, Float.parseFloat(value) );
						}else if("java.lang.Long".equals(typeName) || "long".equals(typeName)){
							m.invoke(t, Long.parseLong(value) );
						}else  if("java.lang.String".equals(typeName)){
							m.invoke(t,value);
						}else{
							//后期扩展
						}
						break;//跳出该循环  
					}
					
				}
				System.out.println(name+"="+value);
			}else{
				String fieldName =item.getFieldName();//获取表单的Name属性值 
				System.out.println("图片名称："+fieldName);
				//获取文件名称 
				String name =item.getName();
				//文件存在服务器的哪个位置 
				String path =request.getServletContext().getRealPath("/");
				//文件重名问题  
				UUID uuid =UUID.randomUUID( );
				String fileName=uuid.toString()+""+name;
				//如果把图片存到项目的目录下，但是当我重启服务器后，项目下上传的图片就消失 
				//服务器webapps目录创建一个名为images的文件夹，就相当于是一个文件项目 
				//文件如何写入到指定位置   项目下 
				//创建文件对象  
				File file =new  File(path,IMAGEPATH+fileName); //(String parent,String child)
				//将文件对象写入到磁盘中 
				item.write(file);
				//获取存储后的文件路径  如何处理 存储到image_path  
				String image_path=IMAGEPATH+fileName;
				for(Method m:methods){
					if(("set"+fieldName).equalsIgnoreCase(m.getName())){
						m.invoke(t, image_path);
					}
				}
			}
		}
		return t;
	}
}
