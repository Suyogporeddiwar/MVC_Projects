<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>logout JSP</title>
<style type="text/css">
body{
     background-image:url("shopping.jpg");
     background-repeat:no-repeat;
     background-size: 100%;
    }
</style>
</head>
<body>
<%
String msg=(String)request.getAttribute("msg");
out.println(msg);
%>
<jsp:include page="home.html"></jsp:include>
</body>
</html>