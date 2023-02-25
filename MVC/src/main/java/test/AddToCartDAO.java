package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddToCartDAO {
	private final static String UPDATE_QUERY="UPDATE PRODUCT49 SET QTY=? WHERE CODE=?";
	int s=0;int c=0;
	public int update(HttpServletRequest req,ArrayList<ProductBean> al)
	{
		//for getting buyer qty in store
		String code[]=req.getParameterValues("product");
		String pqty[]=req.getParameterValues("pqty");
		for(int i=0;i<pqty.length;i++)
		{
			if(!(pqty[i].equals("0")))
				c++;
		}
		
		int pqty1[]=new int[c];
		int j=0;
		for(int i=0;i<pqty.length;i++)
		{
			if(!(pqty[i].equals("0")))
			{
				pqty1[j]=Integer.valueOf(pqty[i]);
				j++;
			}
		}
		//for getting available qty in store
		int pqty2[]=new int[code.length];
	   System.out.println(Arrays.toString(code)+" "+Arrays.toString(pqty1)+" "+code.length);
		int k=0;int L=0;
		for(int i=0;i<al.size();i++)//3
		{
			if(code[k].equals(al.get(i).getPcode()))
			{
				pqty2[k]=al.get(i).getPqty();
			    if(code.length>1) 
			    {
				  k++;
			    }
			}
		}
		int g=0;
		for(int i=0;i<pqty2.length;i++)
		{
			if(pqty2[i]>=pqty1[i])
			{
				continue;
			}
			else {
				g++;	
			}
		}
		String code1[]=new String[g];
		int b=0;
		for(int i=0;i<pqty2.length;i++)
		{
			if(pqty2[i]>=pqty1[i])
			{
				L++;
			}
			else {
				code1[b]=code[i];
				b++;
			}
		}
		
		HttpSession hs=req.getSession(false);
		hs.setAttribute("pcodenotavailable",code1);
		if(L==code.length)
		{
		try {
		Connection con=DBConnection.getConnection();
		for(int i=0;i<code.length;i++)
		{
			PreparedStatement ps=con.prepareStatement(UPDATE_QUERY);
			ps.setInt(1,(pqty2[i]-pqty1[i]));
			ps.setString(2,code[i]);
			s=ps.executeUpdate();
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	  }
		return s;
	}

}
