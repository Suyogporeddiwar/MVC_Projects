<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user login jSP</title>
<style type="text/css">
body{
      background-image:url("shopping.jpg");
      background-repeat:no-repeat;
      background-size:100%;
    }
 div{
      width:300px;
      height:200px;
      top:40%;
      left:43%;
      text-align:center;
      position:absolute;
      align-content:center; 
      font-size:15px;
    } 
  h1{
     margin-top:10%;
     margin-left:43%;
    }
   a{
      font-size:35px;
      color:red;
      margin-right:25%;
    } 
a:hover{
         color:green;
       }        
</style>
</head>
<body>
<%
UserBean ub=(UserBean)session.getAttribute("ubean");
out.println("welcome user "+ub.getFname()+"<br>");
%>
<h1>User DashBoard</h1>
<div>
<a href="viewproduct">view product</a><br><br><br>
<a href="logout">Logout</a>
</div>
</body>
</html>