package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/adminregister")
public class AdminRegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	   int k=new AdminregisterDAO().insert(req);
	   if(k==0)
	   {
		   req.setAttribute("msg","session expired please login again....");
			RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
			rd.forward(req, res);
	   }
	   else
	   {
		   req.setAttribute("msg","admin Registration successful...<br>");
		   RequestDispatcher rd=req.getRequestDispatcher("adminregister.jsp");
		   rd.forward(req, res);
	   }
	}

}
