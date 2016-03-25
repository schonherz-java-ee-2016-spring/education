<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:template>
	<jsp:attribute name="customHead">
     <script
			src="${pageContext.request.contextPath}/resources/js/blogs.js"></script>
     <style>
		.blog {
		max-height: 200px;
		overflow: hidden;
		margin-bottom: 20px;
		}
</style>
    </jsp:attribute>
	<jsp:attribute name="header">
        <h1 class="page-header"> Blog <small> Sport</small>
		</h1>
    </jsp:attribute>
	<jsp:body>
	<div id="blogs" class="text_padding"></div>
	  <ul class="pager">
           <li class="previous">
               <a href="#">&larr; Older</a>
           </li>
           <li class="next">
               <a href="#">Newer &rarr;</a>
           </li>
       </ul>
	</jsp:body>
</template:template>


