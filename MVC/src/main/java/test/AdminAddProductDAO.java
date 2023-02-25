package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class AdminAddProductDAO {
     
	int k=0;
	private static final String INSERT_QUERY="INSERT INTO PRODUCT49 VALUES(?,?,?,?)";
	public int insert(HttpServletRequest req)
	{
		try 
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(INSERT_QUERY);
			ps.setString(1,req.getParameter("pcode"));ps.setString(2,req.getParameter("pname"));
			ps.setFloat(3,Float.parseFloat(req.getParameter("pprice")));
			ps.setInt(4,Integer.parseInt(req.getParameter("pqty")));
		   k=ps.executeUpdate();
		   
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}
}
