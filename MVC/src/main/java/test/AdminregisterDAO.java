package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class AdminregisterDAO {

	int k=0;
	private static final String INSERT_QUERY="INSERT INTO EMPADMIN49 VALUES(?,?,?,?,?,?,?)";
	public int insert(HttpServletRequest req)
	{
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(INSERT_QUERY);
			ps.setString(1,req.getParameter("aname"));
			ps.setString(2,req.getParameter("apass"));
			ps.setString(3,req.getParameter("fname"));
			ps.setString(4,req.getParameter("lname"));
			ps.setString(5,req.getParameter("addre"));
			ps.setString(6,req.getParameter("mid"));
			ps.setLong(7,Long.parseLong(req.getParameter("phno")));
			k=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
