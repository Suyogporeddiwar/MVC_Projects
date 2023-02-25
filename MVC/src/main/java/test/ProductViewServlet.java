package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/viewproduct")
public class ProductViewServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		ArrayList<ProductBean> al=new ProductViewDAO().select(req);
		HttpSession hs=req.getSession(false);
		//ProductBean pbean=new ProductBean();
		if(hs==null)
		{
			req.setAttribute("msg"," sorry! session exipred....please login again..<br>");
		    RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
		    rd.forward(req, res);
		}
		else 
		{
			hs.setAttribute("pbean",al);
			RequestDispatcher rd=req.getRequestDispatcher("productview.jsp");
			rd.forward(req, res);
		}
	}
}
