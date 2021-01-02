package com.yc.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.yc.biz.BizException;


public class Utils {

	/**
	 * 	判断传值是否为空 或空字符串
	 * @param value
	 * @param msg
	 * @throws BizException
	 */
	public static void checkNull(Object value, String msg) throws BizException {
		if (value == null) {
			throw new BizException(msg);
		}
		if (value instanceof String) {
			String svalue = (String) value;
			if (svalue.trim().isEmpty()) {
				throw new BizException(msg);
			}
		}
	}
	
	public static boolean doCheckNotNull(String  info){
		if(null==info||"".equals(info)){
			return false;
		}
		return true;
	}

	public static String getDate(){
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date).toString();
	}
	

}
