package com.yc.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.yc.bean.Admin;
import com.yc.bean.User;


public class DBHelper {

	
	/*
	 * DBHelper新增内容
	 * 1、加入配置文件
	 * .propertise java 属性文件
	 * 2、引入实体类
	 * 3、分页查询方法
	 */

	private static String driver;
	private static String url;
	private static String name;
	private static String pwd;
	public static Connection conn=null;
	public static PreparedStatement pstmt=null;
	public static ResultSet rs=null;	
	
	/*
	 * 静态块
	 */
	static {
		try {
		//读取配置文件==》通过类加载器读取类路径里面的文件
		String path="conn.properties";
		InputStream in=DBHelper.class.getClassLoader().getResourceAsStream(path);
		//创建集合对象
		Properties prop=new Properties();
		prop.load(in);
		driver=prop.getProperty("driver");
		url=prop.getProperty("url");
		name=prop.getProperty("name");
		pwd=prop.getProperty("pwd");
		Class.forName(driver);
		}catch (Exception e) {
			//异常转型+抛出运行期异常
			throw new RuntimeException(e);
			
		}
		
		
	}
	
	
	
	/*
	 * 获取连接对象
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, name, pwd);
	}
	
	public static void main(String[] args) throws Exception  {
		List<User> list1 =selectList("select * from user where uid<30",
				new ResultSetMapper<User>() {
			
					public User map(ResultSet rs) throws SQLException{
						User ss=new User();
						ss.setUid(rs.getInt("uid"));
						ss.setUname(rs.getString("uname"));
						ss.setPhone(rs.getString("phone"));
						ss.setEmail(rs.getString("email"));
						ss.setAddress(rs.getString("address"));
							
							return ss;
					}

				});
		List<Admin> list2 =selectList("select * from admin where aid<30",
				new ResultSetMapper<Admin>() {
			
					public Admin map(ResultSet rs) throws SQLException{
						Admin vv=new Admin();
						vv.setAid(rs.getInt("aid"));
						vv.setAdname(rs.getString("adname"));
							
							return vv;
					}

				});
				System.out.println(list1.size());
				System.out.println(list2.size());
				System.out.println(list1);
	}
	
	
	
	//修改参数
	
	public static int update(String sql, Object...params) throws SQLException {
		System.out.println("SQL:"+sql);
		System.out.println("参数:"+Arrays.toString(params));
		Connection conn=getConnection();
		try {
			//创建语句对象
			PreparedStatement ps=conn.prepareStatement(sql);
			//设置查询参数
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1, params[i]);
			}
			return ps.executeUpdate();
		}finally {
			conn.close();
		}
		
	}
	
	/*查询歌手数据
	 * 
	 * @return
	 * @
	 */
	public static <T> List<T>selectList(
		String sql,
		ResultSetMapper<T>callback,
		Object...params)throws SQLException{
		
		System.out.println("SQL:"+sql);
		System.out.println("参数："+Arrays.toString(params));
		Connection conn=getConnection();
		try {
			//创建语句对象
			PreparedStatement ps=conn.prepareStatement(sql);
			//设置查询参数
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			} 
			//执行语句
			ResultSet rs=ps.executeQuery();
			//定义返回结果
			List<T>ret=new ArrayList<>();
			for (;rs.next();) {
				T t=callback.map(rs);
				ret.add(t);
				
			}
			return ret;
		} finally {
			conn.close();
		}
	}
	
	/**
	 * 	将结果集映射到Map中的映射器实现类
	 */
	public static ResultSetMapper<Map<String, Object>> RsMapMapper = new ResultSetMapper<Map<String, Object>>() {
		@Override
		public Map<String, Object> map(ResultSet rs) throws SQLException {
			// 定义返回结果
			Map<String, Object> ret = new LinkedHashMap<String, Object>();
			// 获取结果集元数据对象
			ResultSetMetaData md = rs.getMetaData();
			// 遍历该结果集所有的列
			for (int i = 0; i < md.getColumnCount(); i++) {
				// 获取当前列的列名
				String columnName = md.getColumnName(i + 1);
				// 获取当前列的列值
				Object columnValue = rs.getObject(columnName);
				// 添加到map集合中
				ret.put(columnName, columnValue);
			}
			// 返回映射后的 map 集合
			return ret;
		}
	};
	
		//回调接口。泛型接口
	
		public static interface ResultSetMapper<T>{
			T map(ResultSet rs)throws SQLException;
		}

		/**
		 * 	将查询结果，装载到List中存Map的集合
		 */
		public static List<Map<String, Object>> selectListMap(String sql, Object... params) throws SQLException {
			return selectList(sql, RsMapMapper, params);
		}

		/**
		 *	查询单行结果集（Map） 
		 */
		public static Map<String, Object> selectOneMap(String sql, Object... params) throws SQLException {
			sql = "select * from (" + sql + ") limit 0, 1";
			List<Map<String, Object>> ret = selectList(sql, RsMapMapper, params);
			if (ret.size() > 1) {
				throw new SQLException("查询结果行数大于1！");
			} else if (ret.isEmpty()) {
				return null;
			} else {
				return ret.get(0);
			}
		}


		/**
		 *	查询单值结果集（Map） 
		 */
		public static Object selectValue(String sql, Object... params) throws SQLException {
			Map<String, Object> ret = selectOneMap(sql, params);
			// 将 值 集合转换成数组，返回第一个值（查询结果中的第一列的值）
			return ret.values().toArray()[0];
		}
		
		public static PreparedStatement createPreparedStatement(String sql,Object[] params){		
			try {

				if(params!=null){
					for(int i=0;i<params.length;i++){
						pstmt.setObject(i+1, params[i]);
					}	
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			return pstmt;
		}

		
public static ResultSet executeQuery(String sql,Object[] params){
		//这里的rs不能关闭，因为返回的是结果集，其他类还要使用！！！！！。
		
		
		try {
			pstmt=createPreparedStatement(sql, params);
			rs=pstmt.executeQuery();
		}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return rs;
		}


		
	}

