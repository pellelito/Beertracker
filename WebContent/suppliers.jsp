<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.List" %>
     <%@page import="beer.LoginDB"%>
     
    
    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<title>BeerTracker</title>
   <style type="text/css">
    <%@include file="WEB-INF/style.css" %></style>
</head>
<body>
<h1>BeerTracker</h1>
<%
LoginDB DB = new LoginDB();
String result = DB.list((String)session.getAttribute("uname"),(String)session.getAttribute("psw"),"brewery");
String uname = (String) session.getAttribute("uname");
String psw = (String) session.getAttribute("psw");
pageContext.setAttribute("result", result);
%>

<h3>${result}</h3>
<form action="menu.jsp"><button>Back to menu</button></form>

<form action="update" method="post">
	<input type="text" placeholder="Brewery" name="Brewery_Name" required>
	<input type="text" placeholder="Location" name="Brewery_Location" required>
	<input type="hidden" name="table" value="brewery">
	<input type="hidden" name="uname" value="${uname}">
	<input type="hidden" name="psw" value="${psw}">
	<button type="submit">Add</button>
</form>

<form action="index.jsp"><button>Log out</button></form>

</body>
</html>