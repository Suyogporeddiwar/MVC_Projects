<%@page import="javax.crypto.interfaces.PBEKey"%>
<%@page  import="java.util.Iterator"%>
<%@page  import="test.UserBean"%>
<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="test.ProductBean,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProductViewJSP</title>
<style type="text/css">
body{
      background-image: url("shopping.jpg");
      background-repeat:no-repeat;
      background-size:100%;
    }
  h1{
      margin-top:8%;
      margin-left:47%;
    } 
 div{
      font-size:20px;
      margin-left:48%;
      margin-top:5%;
      width:400px;
      height:200px;
    }
   a{
      color:red;
      margin-left:6%;
      font-size:30px;
    } 
a:hover{
         color:green;
       }
.input{
	    width:25px;
	    height:16px;
	    
      }
#input1{
         width:150px;
         height:30px;
         font-size:25px;
         text-align:center;;
         border:none;
         border-radius:7px;
         background-color:orange;
         margin-left:3%;
       }
 #input2{
           width:20px;
           height:16px;
           
        }                           
</style>
</head>
<body>

<%
UserBean be=(UserBean)session.getAttribute("ubean");
out.println("welcome user "+be.getFname()+"<br>");
ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("pbean");

 if(al.size()==0)
 {
	 out.println("product not available");
 }
 else
 {
 Iterator<ProductBean> it=al.iterator();
 %>
 <h1>User DashBoard</h1>
 <div>
 
<form action="addcart" method="post" id="submit">
 <% 
 out.print("pcode"+"\t\t"+"pname"+"\t\t"+"pprice"+"\t\t"+"pqty<br>");
 while(it.hasNext())
 {
	 ProductBean bean=(ProductBean)it.next();
%>
<input  id="input2" type="checkbox" name="product" value="<%=bean.getPcode()%>"/>

<% 
	 out.println(bean.getPcode()+" "+bean.getPname()+" "+bean.getPprice()+" "+bean.getPqty());
%>
<input class="input" type="text" name="pqty" value="0" /><br>
<% 	 
 }
 }
%>
<br>
<input id="input1" type="submit" value="add to cart"/>
</form><br>
<a href="logout">Logout</a>
</div>

</body>
</html>