package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class AdminLoginDAO {

	AdminBean aBean=null;
	private static final String SELECT_QUERY="SELECT * FROM EMPADMIN49 WHERE UNAME=? AND PWORD=?";
	public AdminBean select(HttpServletRequest req)
	{
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
			ps.setString(1,req.getParameter("aname"));
			ps.setString(2,req.getParameter("apass"));
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				aBean=new AdminBean();
				aBean.setUname(rs.getString(1));
				aBean.setPass(rs.getString(2));
				aBean.setFnaem(rs.getString(3));
				aBean.setLname(rs.getString(4));
				aBean.setAddre(rs.getString(5));
				aBean.setMid(rs.getString(6));
				aBean.setPhno(rs.getLong(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aBean;
	}
}
