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
@WebServlet("/user")
public class UserloginServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		UserBean ub=new UserLoginDAO().select(req);
		if(ub==null)
		{
			req.setAttribute("msg","invalid username or password.....");
			RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
			rd.forward(req, res);
		}
		else {
			
			HttpSession hs=req.getSession();
			hs.setAttribute("ubean", ub);
			RequestDispatcher rd=req.getRequestDispatcher("userlogin.jsp");
			rd.forward(req, res);
		}
	}
}
