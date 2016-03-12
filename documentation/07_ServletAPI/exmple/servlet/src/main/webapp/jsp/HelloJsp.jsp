<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!-- Use JSTL tags, and those will be access via 'c' (like c:out) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- page wont ignore EL expression ${ expression } -->
<%@ page isELIgnored="false" %>

<jsp:useBean id="commentsBean" class="hu.sconhertz.training.beans.CommentsBean" scope="application"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	final String NEWCOMMENT = "newcomment";
	final String NAME = "name";
	String[] contributors = {"Kiss Aladár", "Nagy Béla"};
	// for access contributors via EL expression, you need to ad it to pageContext
	pageContext.setAttribute("contributors", contributors);
	
	// Without action you can use modify the bean in this way
	/*
	if(request.getParameter(NEWCOMMENT) != null) {
	  List<String> comments = commentsBean.getComments();
	  if(comments == null) {
	    comments = new ArrayList<String>();
	  }
	  comments.add(request.getParameter(NEWCOMMENT));
	  commentsBean.setComments(comments);
	}*/
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My first JSP</title>
</head>
<body>
	<h1>Hello <%=request.getParameter(NAME)%>!</h1>
	
	<div style="margin-bottom: 30px">
		<h2>Comments:</h2>
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
			<!-- c:forEach go trough the commentsBean.getComments() collection 
				and the body of this tag will run in each iteration
				${commentsBean.comments} -> commentsBean.getComments()
			-->
			<c:forEach items="${commentsBean.comments}" var="comment">
				<div style="border: solid 1px; margin: 2px 0px">
					<!-- Instead replacing new line pre (preformatted) tag will show \n as well  -->
					<pre>${comment}</pre>
				</div>
			</c:forEach>
		</c:if>
	</div>
	
	<h2>You can add a new comment:</h2>
	<!-- The form will post to HelloJsp.jsp 
	<form action="HelloJsp.jsp" method="post">-->
	<!-- The form will be post to HelloJSPAction servlet 
		 ${pageContext.request.contextPath} -> http://localhost:8080/servlet
	-->
	<form action="${pageContext.request.contextPath}/HelloJSPAction" method="post">
		<input type="hidden" name="<%=NAME%>" value="<%=request.getParameter("name")%>">
		<textarea rows="2" cols="50" name="<%=NEWCOMMENT%>"></textarea>
		<input type="submit" value="Submit"></input>
	</form>
	
	<div>
		<h2>Contributors:</h2>
		<ul>
			<!-- The same collection go though as below but with c:forEach
			<c:forEach items="${contributors}" var="contributor">
				<li>${contributor}</li>
			</c:forEach> -->
		<!-- Wihout c:ForEach you can go trough an collection via Java code  -->
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