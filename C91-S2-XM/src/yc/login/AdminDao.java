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
		String sql="select * from user where adname=? and adpwd=? ";
		
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
		

}
