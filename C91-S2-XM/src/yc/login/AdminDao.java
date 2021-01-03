package yc.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Admin;
import com.yc.bean.User;
import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;


public class AdminDao {
	public List<Admin> Login(String adname,String adpwd) throws SQLException{
		String sql="select * from admin where adname=? and adpwd=? ";
		
		return DBHelper.selectList(sql, new ResultSetMapper<Admin>() {

			@Override
			public Admin map(ResultSet rs) throws SQLException {
				Admin a=new Admin();
				a.setAdname(rs.getString("adname"));
				
				a.setAdpwd(rs.getString("adpwd"));
				
				return a;
			}
		
		}, adname,adpwd);
	}

	//用户实体对象属性映射类，因后续多次调用，所以单独建立一个类
	class AdminMapper implements ResultSetMapper<Admin>{

		@Override
		public Admin map(ResultSet rs) throws SQLException {
			Admin vv=new Admin();
			vv.setAid(rs.getInt("aid"));
			vv.setAdname(rs.getString("adname"));
			
				
				return vv;
		}
	}

	
		

}
