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
@WebServlet("/adminlogin")
public class AdminloginServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		AdminBean aBean=new AdminLoginDAO().select(req);
		
		if(aBean==null)
		{
			req.setAttribute("msg","login failed due to invalid username and password <br>");
		    RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
		    rd.forward(req, res);
		}
		else 
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("abean",aBean);
			RequestDispatcher rd=req.getRequestDispatcher("adminlogin.jsp");
		    rd.forward(req, res);
		}
	}
}
