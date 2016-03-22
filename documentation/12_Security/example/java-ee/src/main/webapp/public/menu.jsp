<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<ul>
	<li><a href="<%=request.getContextPath()%>/secured/admin/admin.jsp">Admin</a></li>
	<li><a href="<%=request.getContextPath()%>/secured/manager/manager.jsp">Manager</a></li>
	<li><a href="<%=request.getContextPath()%>/secured/user.jsp">User</a></li>
	<li><a href="<%=request.getContextPath()%>/SecuredServlet">SecuredServlet</a></li>
	<li><a href="<%=request.getContextPath()%>/SecuredSecuredServlet">SecuredSecuredServlet</a></li>
	<li><a href="<%=request.getContextPath()%>/index.jsp">Index</a></li>
	<li><a href="<%=request.getContextPath()%>/LogOutServlet">LogOut</a></li>
</ul>
<ul>
	<li>getAuthType: <%=request.getAuthType()%></li>
	<li>isUserInRole("admin"): <%=request.isUserInRole("admin")%></li>
	<li>getProtocol(): <%=request.getProtocol()%></li>
	<li>isSecure() <%=request.isSecure()%></li>
	<li>getUserPrincipal() <%=request.getUserPrincipal()%></li>
	<li>isRequestedSessionIdValid() <%=request.isRequestedSessionIdValid()%></li>
</ul>