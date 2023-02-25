package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminViewDAO {

	ArrayList<ProductBean> al=new ArrayList<>();
	private final static String SELECT_QUERY="SELECT * FROM PRODUCT49";
	public ArrayList<ProductBean> view()
	{
		try {
			
		   Connection con=DBConnection.getConnection();
		   PreparedStatement ps=con.prepareStatement(SELECT_QUERY);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   ProductBean pb=new ProductBean();
			   pb.setPcode(rs.getString(1));
			   pb.setPname(rs.getString(2));
			   pb.setPprice(rs.getFloat(3));
			   pb.setPqty(rs.getInt(4));
			   al.add(pb);
		   }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}
