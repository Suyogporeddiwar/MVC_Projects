package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		int k=new UserRegisterDAO().insert(req);
		if(k==0)
		{
			req.setAttribute("msg","session expired please login again....");
			RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
			rd.forward(req, res);
		}
		else
		{
			req.setAttribute("msg","user successfully registered....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("UserRegister.jsp");
			rd.forward(req, res);
		}
	}
}
