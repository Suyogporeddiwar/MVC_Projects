<%@page import="test.AdminBean"%>
<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="test.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminviewproductbycode.jsp</title>
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
ProductBean bean=(ProductBean)session.getAttribute("bean");
out.println(bean.getPcode()+"  "+bean.getPname()+"  "+bean.getPprice()+"  "+bean.getPqty()+"<br>");
%>
<jsp:include page="adminlogin.jsp"></jsp:include>
</body>
</html>