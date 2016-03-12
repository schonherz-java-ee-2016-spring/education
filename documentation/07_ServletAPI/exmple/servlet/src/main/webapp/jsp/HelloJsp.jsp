<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% String[] contributors = {"Kiss Aladár", "Nagy Béla"}; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My first JSP</title>
</head>
<body>
	<h1>Hello <%=request.getParameter("name") %>!</h1>
	<div>
		Contributors:
		<ul>
		<% 
			for(String contributor : contributors) {
		%>
			<li><%=contributor%></li>
		<%
			}
		%>
		</ul>
	</div>
</body>
</html>