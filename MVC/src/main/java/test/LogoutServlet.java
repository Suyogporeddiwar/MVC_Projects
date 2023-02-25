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
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg","session expired please login again....<br>");
		   RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
		   rd.forward(req, res);
		}
		else {
			
			hs.removeAttribute("ubean");
			hs.invalidate();
			req.setAttribute("msg","you are successfully logout....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("logout.jsp");
			rd.forward(req, res);
		}
	}
}
