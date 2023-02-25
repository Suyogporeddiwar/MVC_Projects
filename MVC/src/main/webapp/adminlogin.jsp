<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin login jsp</title>
<style type="text/css">
 body{
       background-image:url("shopping.jpg");
       background-repeat:no-repeat;
       background-size:100%;
     }
   h1{
       margin-top:8%;
       margin-left:40%;
     }
    a{
      font-size:25px;
      color:red;
     }
a:hover{
         color:green;
         cursor:pointer;
       }     
  div{
       width:350px;
       height:250px;
       text-align:center;
       align-content:center;
       position:absolute;
       margin-top:4%;
       margin-left:37%;
     }     
</style>

</head>
<body>
<%
AdminBean abean=(AdminBean)session.getAttribute("abean");
out.println("welcome admin :"+abean.getFnaem()+"<br>");
%>
<h1>Admin DashBoard</h1>
<div>
<a href="adminview">view product</a><br><br>
<a href="adminaddproduct.html">add product</a><br><br>
<a href="adminupdateproduct.html">edit product by code</a><br><br>
<a href="admindeleteproductbycode.html">delete product by code</a><br><br>
<a href="adminviewproductbycode.html">view product by code</a><br><br>
<a href="logout">Logout</a>
</div>
</body>
</html>