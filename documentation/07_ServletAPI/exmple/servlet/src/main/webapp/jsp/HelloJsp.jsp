<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Use JSTL tags, and those will be access via 'c' (like c:out) -->
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- page wont ignore EL expression ${ expression } -->
<%@ page isELIgnored="false" %>
<jsp:useBean id="commentsBean" class="hu.sconhertz.training.beans.CommentsBean" scope="application"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	final String NEWCOMMENT = "newcomment";
	String[] contributors = {"Kiss Aladár", "Nagy Béla"};
	pageContext.setAttribute("contributors", contributors);
	
	if(request.getParameter(NEWCOMMENT) != null) {
	  List<String> comments = commentsBean.getComments();
	  if(comments == null) {
	    comments = new ArrayList<String>();
	  }
	  comments.add(request.getParameter(NEWCOMMENT));
	  commentsBean.setComments(comments);
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My first JSP</title>
</head>
<body>
	<h1>Hello <%=request.getParameter("name") %>!</h1>
	
	<div>
		Comments:
		<!-- c:choose is the Java switch-case
		<c:choose>
			<c:when test="${commentsBean.comments == null}">
				There is no comment yet.
			</c:when>
			<c:otherwise>
				There is some comment.
			</c:otherwise>
		</c:choose>-->
		<!-- there is c:if, but there is no c:else -->
		<c:if test="${commentsBean.comments == null}">
			There is no comment yet.
		</c:if>
		<c:if test="${commentsBean.comments != null}">
			<c:forEach items="${commentsBean.comments}" var="comment">
				<div style="border: solid 1px">
					${comment}
				</div>
			</c:forEach>
		</c:if>
	</div>
	
	<form action="HelloJsp.jsp" method="post">
		<textarea rows="2" cols="50" name="<%=NEWCOMMENT%>"></textarea>
		<input type="submit" value="Submit"></input>
	</form>
	
	<div>
		<h2>Contributors:</h2>
		<ul>
			<c:forEach items="${contributors}" var="contributor">
				<li>${contributor}</li>
			</c:forEach>
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