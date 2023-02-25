package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class UserLoginDAO {

	UserBean ub=null;
	private static final String SELECT_QUERY="SELECT * FROM USERREG49 WHERE UNAME=? AND PWORD=?";
	public UserBean select(HttpServletRequest req)
	{
		try {
			
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
			ps.setString(1,req.getParameter("uname"));
			ps.setString(2,req.getParameter("upass"));
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ub=new UserBean();
				ub.setUname(rs.getString(1));
				ub.setUpass(rs.getString(2));
				ub.setFname(rs.getString(3));
				ub.setLname(rs.getString(4));
				ub.setAdd(rs.getString(5));
				ub.setMid(rs.getString(6));
				ub.setPhno(rs.getLong(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ub;
	}
}
