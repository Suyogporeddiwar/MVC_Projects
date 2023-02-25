package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/addcart")
public class AddToCartServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		int c=0;
		String code[]=req.getParameterValues("product");
		String pqty[]=req.getParameterValues("pqty");
		
		for(int i=0;i<pqty.length;i++)
		{
			if(!(pqty[i].equals("0")))
				c++;
		}
		String pqty1[]=new String[c];
		int j=0;
		for(int i=0;i<pqty.length;i++)
		{
			if(!(pqty[i].equals("0")))
			{
				pqty1[j]=pqty[i];
				j++;
			}
		}
		
		float price[]=new float[code.length];
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg"," sorry! session exipred....please login again..<br>");
		    RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
		    rd.forward(req, res);
		}
		
		else {	
		ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("pbean");
		ArrayList<Float> al1=new ArrayList<>();
		Map<String,Float> al2=new HashMap<>();
		
		int u=new AddToCartDAO().update(req,al);
		
		if(u==0)
		{
			hs.setAttribute("notavailable",u);
			hs.setAttribute("productout","product out of stock select only those product which is available in store....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("showbill.jsp");
			rd.forward(req, res);
		}
		else {
			
		float tot=0;
		for(int i=0;i<al.size();i++)
		{
			al1.add(al.get(i).getPprice());
		}
		int k=0;int m=0;
		float productsum[]=new float[code.length];
		for(int i=0;i<al.size();i++)
		{
		  if(code[k].contains(al.get(i).getPcode()))
		  {
			  price[m]=al.get(i).getPprice();
			  al2.put(al.get(i).getPcode(),al.get(i).getPprice());
			  if(code.length>1)
			  {
			  m++;k++;
			  }
		  }
		}
		
		for(int i=0;i<price.length;i++)
		{
			tot=tot+(price[i]*Integer.valueOf(pqty1[i]));
			productsum[i]=price[i]*Integer.valueOf(pqty1[i]);
			
		}
		hs.setAttribute("notavailable",u);
		hs.setAttribute("productsum",productsum);
		hs.setAttribute("sellingqty",pqty1);
		hs.setAttribute("selectproduct",al2);
		hs.setAttribute("totbill"," total bill amount is= "+tot);
		RequestDispatcher rd=req.getRequestDispatcher("showbill.jsp");
		rd.forward(req, res);
		
	   }
	 }
   }
}
