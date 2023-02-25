package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class AdminDeleteProductByCodeDAO {

	int k=0;
	private final static String DELETE_QUERY="DELETE FROM PRODUCT49 WHERE CODE=?";
	public int delete(HttpServletRequest req)
	{
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(DELETE_QUERY);
			ps.setString(1,req.getParameter("pcode"));
			k=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
