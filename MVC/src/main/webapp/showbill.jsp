<%@page import="java.util.Arrays"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="test.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>showbill.jsp</title>
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

UserBean bean=(UserBean)session.getAttribute("ubean");
out.println("welecome user "+bean.getFname()+"<br>");
String productout=(String)session.getAttribute("productout");
int notAvailable=(int)session.getAttribute("notavailable");
String code2[]=(String[])session.getAttribute("pcodenotavailable");
if(notAvailable==0)
{
	out.println(Arrays.toString(code2)+" "+productout);
}
else{
out.println("you are shopping from us following products<br>");
float productsum[]=(float[])session.getAttribute("productsum");
String qty[]=(String[])session.getAttribute("sellingqty");
String totbill=(String)session.getAttribute("totbill");
HashMap<String,Float> al1=(HashMap<String,Float>)session.getAttribute("selectproduct");
ArrayList al=new ArrayList(al1.entrySet());
Iterator it=al.iterator();
int i=0;
while(it.hasNext())
{
	Entry e=(Entry)it.next();
	out.println(e.getKey()+"  "+e.getValue()+"  *   "+qty[i]+" = "+productsum[i]+"<br>");
	i++;
}
out.println(totbill+"<br>");
out.println("thank you sir for shopping with us...visit again");
}
%>
<br>
<a href="logout">Logout</a>&ensp;&ensp;
<a href="productview.jsp">previous</a>
</body>
</html>