package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class AdminUpdateProductDAO {

	int k=0;
	private static final String UPDATE_QUERY="UPDATE PRODUCT49 SET CODE=?,NAME=?,PRICE=?,QTY=? WHERE CODE=?";
	
	public int update(HttpServletRequest req)
	{
		try 
		{
		  Connection con=DBConnection.getConnection();
		  PreparedStatement ps=con.prepareStatement(UPDATE_QUERY);
		  ps.setString(1,req.getParameter("code"));
		  ps.setString(2,req.getParameter("name"));
		  ps.setFloat(3,Float.parseFloat(req.getParameter("price")));
		  ps.setInt(4,Integer.parseInt(req.getParameter("qty")));
		  ps.setString(5,req.getParameter("pcode"));
		  k=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
