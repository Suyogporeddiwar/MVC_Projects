package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ProductViewDAO {
	
	ArrayList<ProductBean> al=new ArrayList<>();
	private static final String SELECT_QUERY="SELECT * FROM PRODUCT49";
	public ArrayList<ProductBean> select(HttpServletRequest req)
	{
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ProductBean bean=new ProductBean();
				bean.setPcode(rs.getString(1));
				bean.setPname(rs.getString(2));
				bean.setPprice(rs.getFloat(3));
				bean.setPqty(rs.getInt(4));
				al.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
