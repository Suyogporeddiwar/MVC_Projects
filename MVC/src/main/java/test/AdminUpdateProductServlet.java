package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/updateproduct")
public class AdminUpdateProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		int k=new AdminUpdateProductDAO().update(req);
		if(k==0)
		{
			req.setAttribute("msg","session exipred....please login again..<br>");
		    RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
		    rd.forward(req, res);
		}
		else 
		{
			HttpSession hs=req.getSession(false);
			hs.setAttribute("msg","product updated successfully.....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("adminupdateproduct.jsp");
			rd.forward(req, res);
		}
	}
}
