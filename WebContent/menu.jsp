<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<form action="suppliers.jsp" method="post"><button >Suppliers</button></form>
<form action="customers.jsp" method="post"><button>Customers</button></form>
<form action="products.jsp" method="post"><button >Products</button></form>
<form action="orders.jsp" method="post"><button>Orders</button></form>
<form action="index.jsp"><button>Log out</button></form>

<%
if (request.getParameter("uname")!=null){
	session.setAttribute("uname", request.getParameter("uname"));
	session.setAttribute("psw", request.getParameter("psw"));	
}

%>


</body>
</html>