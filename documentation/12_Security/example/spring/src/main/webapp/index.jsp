<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<body>

	<jsp:include page="public/menu.jsp"></jsp:include>

	<h2>Hello World!</h2>


	<sec:authorize access="hasRole('USER')">

		<h2>Hello user!</h2>

	</sec:authorize>

	<sec:authorize access="hasRole('MANAGER')">

		<h2>Hello manger!</h2>

	</sec:authorize>
	<sec:authorize access="hasRole('ADMIN')">

		<h2>Hello admin!</h2>

	</sec:authorize>


	UserName:
	<br /> 
	Password:
	<sec:authentication property="credentials" />
	<br /> 
	Role:
	<sec:authentication property="authorities" />
	<br />


	<sec:authorize access="isRememberMe()">
		<h1>isRememberMe()</h1>
	</sec:authorize>
	<sec:authorize access="!isRememberMe()">
		<h1>no isRememberMe()</h1>
	</sec:authorize>

</body>
</html>
