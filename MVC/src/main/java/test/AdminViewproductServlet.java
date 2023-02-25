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
@WebServlet("/adminview")
public class AdminViewproductServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		ArrayList<ProductBean> al=new AdminViewDAO().view();
		if(al==null)
		{
			req.setAttribute("msg","session expired please login again....");
			RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
			rd.forward(req, res);
		}
		else 
		{
			HttpSession hs=req.getSession(false);
			hs.setAttribute("al", al);
			RequestDispatcher rd=req.getRequestDispatcher("adminviewproduct.jsp");
			rd.forward(req, res);
		}
	}

}
