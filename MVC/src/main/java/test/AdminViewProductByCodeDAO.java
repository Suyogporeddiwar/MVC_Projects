package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class AdminViewProductByCodeDAO {

	ProductBean bean=null;
	private static final String SELECT_QUERY="SELECT * FROM PRODUCT49 WHERE CODE=?";
	public ProductBean select(HttpServletRequest req)
	{
		try 
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
			ps.setString(1,req.getParameter("pcode"));
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				bean=new ProductBean();
				bean.setPcode(rs.getString(1));
				bean.setPname(rs.getString(2));
				bean.setPprice(rs.getFloat(3));
				bean.setPqty(rs.getInt(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}
