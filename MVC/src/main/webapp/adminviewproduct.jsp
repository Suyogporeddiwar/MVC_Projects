<%@page  import="java.util.Iterator"%>
<%@page  import="java.util.ArrayList" %>
<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="test.*,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin view product</title>
<style type="text/css">
 body{
       background-image:url("shopping.jpg");
       background-repeat:no-repeat;
       background-size:100%;
     }
</style>

</head>
<body>
<%
/*AdminBean adb=(AdminBean)session.getAttribute("abean");
out.println("welcome admin : "+adb.getFnaem()+"<br>");*/

  ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("al");

  if(al.size()==0)
  {
	  out.println("product not available<br>");
  }
  else{
	 
	   
  Iterator<ProductBean> it=al.iterator();
  while(it.hasNext())
  {
	  ProductBean pb=(ProductBean)it.next();


	
	  out.println(pb.getPcode()+"  "+pb.getPname()+"  "+pb.getPprice()+"  "+pb.getPqty()+"<br>");
  }
  }
%>

<jsp:include page="adminlogin.jsp"/>
</body>
</html>