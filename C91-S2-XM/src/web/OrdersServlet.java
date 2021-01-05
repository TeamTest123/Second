package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.bean.Orders;
import com.yc.dao.OrdersDao;


@WebServlet("/OrdersServlet.action")
public class OrdersServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   private OrdersDao oDao=new OrdersDao();
   
	/**
	 * 后台订单分页查询
	 * @return
	 */
	protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
		
		String page=request.getParameter("page");
		
		int iPage = page ==null ? 1: Integer.parseInt(page);
		
		List<Orders> rows = oDao.selectPage(iPage);
		int total=oDao.selectCount();
		
		Map<String, Object>data=new HashMap<>();
		data.put("rows", rows);
		data.put("total", total);
		
		//数据如何发送给浏览器?
		//JSON
		//JSON格式
		//[ {"id":1,"name":"yc",....},{},{}    ]
		String json=new Gson().toJson(data);
		System.out.println(json);
		response.getWriter().append(json);

		}
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException {
		String did=request.getParameter("did");
		oDao.updateStatus("已发货", Integer.parseInt(did));
		
	}
	
	public void update2(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException {
		String did=request.getParameter("did");
		oDao.updateStatus("交易成功", Integer.parseInt(did));
		
	}
	
	public void QueryCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append(""+oDao.selectCount());

	}
}
