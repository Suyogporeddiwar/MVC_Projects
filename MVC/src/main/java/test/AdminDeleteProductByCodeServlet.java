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
@WebServlet("/admindeleteproductbycode")
public class AdminDeleteProductByCodeServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	int k=new AdminDeleteProductByCodeDAO().delete(req);
	
	if(k==0)
	{
		req.setAttribute("msg","session expired please login again....");
		RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
		rd.forward(req, res);
	}
	else
	{
		HttpSession hs=req.getSession(false);
		hs.setAttribute("msg","product successfully deleted...<br>");
		RequestDispatcher rd=req.getRequestDispatcher("admindeleteproductbycode.jsp");
		rd.forward(req, res);
	}
 }
}
