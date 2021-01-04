package yc.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.yc.bean.User;
import com.yc.util.DBHelper;
import com.yc.util.DBHelper.ResultSetMapper;


public class LoginDAO {
	public List<User> Login(String uname,String upwd) throws SQLException{
		String sql="select * from user where uname=? and upwd=? and status=1 ";
		
		return DBHelper.selectList(sql, new ResultSetMapper<User>() {

			@Override
			public User map(ResultSet rs) throws SQLException {
				User u=new User();
				u.setUname(rs.getString("uname"));
				u.setUid(rs.getInt("uid"));
				u.setUpwd(rs.getString("upwd"));
				
				return u;
			}
		
		}, uname,upwd);
	}
	
	
	
		

}
