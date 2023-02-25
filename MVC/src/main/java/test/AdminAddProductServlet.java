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
@WebServlet("/adminadd")
public class AdminAddProductServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		int k=new AdminAddProductDAO().insert(req);
		if(k==0)
		{
			req.setAttribute("msg","session expired please login again....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
			rd.forward(req, res);
		}
		else 
		{
			HttpSession hs=req.getSession(false);
			hs.setAttribute("msg","product added successfully....<br>" );
		    RequestDispatcher rd=req.getRequestDispatcher("adminaddproduct.jsp");
		   rd.forward(req, res);
		}
	}
}
