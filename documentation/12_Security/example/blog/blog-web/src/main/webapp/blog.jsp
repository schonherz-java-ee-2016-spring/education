<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Free BinaryNews Template For sNews</title>
<meta http-equiv="content-type" content="text/html;charset=iso-8859-2" />
<link rel="stylesheet" href="resources/css/style.css" type="text/css" />
<link rel="stylesheet"
	href="https:////code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="resources/js/blog.js"></script>

</head>
<body>
	<div class="content">
		<div class="preheader">
			<div class="padding">
				<a href="#">About</a>&nbsp; <a href="#">Contact</a>
				<a href="${pageContext.request.contextPath}/login.jsp">Login</a>
			</div>
		</div>
		<div class="header">
			<div class="title">YOUR COMPANY NAME</div>
			<div class="slogan">Your Best Slogan Here</div>
		</div>
		<div id="nav">
			<ul>
				<li><a href="/blog-web">Blog</a></li>

			</ul>
		</div>
		<div class="main_content">
			<div class="sd_right">
				<div class="text_padding">
					<h2>BinaryNews</h2>
					sit amet consectetuer adipiscing elit. Donec libero. Suspendisse
					bibendum. Cras id urna. Morbi tincidunt, orci ac convallis aliquam,
					lectus turpis varius lorem, eu posuere nunc justo tempus leo. Donec
					mattis, purus nec placerat bibendum, dui pede condimentum odio. <br />
					<h2>Search</h2>
					<form method="post" action="#">
						<p>
							<input type="text" name="search" class="search" /> <input
								type="submit" value="Go" class="submit" />
						</p>
					</form>
					<br />
					<h2>Last Articles</h2>
					<a href="#">Link to a article</a><br /> <a href="#">Link to
						another article...</a><br /> <br />
					<h2>Links</h2>
					<a href="#">www.solucija.com</a><br /> <a href="#">ww.free-css-templates.com</a><br />
				</div>
			</div>
			<div class="sd_left">

				<div id="blogs" class="text_padding"></div>
				<div id="comments" class="text_padding"></div>

				<sec:authorize access="hasRole('USER')">

					<input type="text" id="comment" />

					<button id="addComment" type="button" onclick="addComment();">Add comment</button>
				</sec:authorize>

			</div>

			<div class="footer">
				<div class="padding">
					Powered by <a href="http://snews.solucija.com"
						title="Single file CSS and XHTML valid CMS">sNews</a> | &copy;
					Copyright BinaryNews Template :: Design: <a
						href="http://www.free-css-templates.com/"
						title="Free CSS Templates">David Herreman</a> | <a href="rss/">RSS
						Feed</a> | <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a>
					and <a href="http://validator.w3.org/check?uri=referer">XHTML</a> |
					<a href="#">Login</a>
				</div>
			</div>
		</div>
	</div>


	<input type="hidden" id="blogId"
		value="<%=request.getParameter("blogId")%>"></input>

</body>
</html>
