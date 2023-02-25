<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminDeleteProductByCodeJSP</title>
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
String msg=(String)session.getAttribute("msg");
out.println(msg);
%>
<jsp:include page="adminlogin.jsp"/>
</body>
</html>