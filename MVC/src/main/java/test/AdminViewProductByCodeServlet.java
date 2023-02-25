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
@WebServlet("/viewproductbycode")
public class AdminViewProductByCodeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		ProductBean bean=new AdminViewProductByCodeDAO().select(req);
		
		if(bean==null)
		{
			req.setAttribute("msg","session exipred....please login again..<br>");
		    RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
		    rd.forward(req, res);
		}
		else 
		{
			HttpSession hs=req.getSession(false);
			hs.setAttribute("bean",bean);
			RequestDispatcher rd=req.getRequestDispatcher("adminviewproductbycode.jsp");
			rd.forward(req, res);
		}
	}
}
