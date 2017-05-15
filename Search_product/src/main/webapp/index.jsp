<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<html>
<head>
<title>Home</title>

</head>
<body>
	<jsp:include page="/WEB-INF/pages/template.jsp">
		<jsp:param value="Hello my future employer!" name="pageTitle"/>
		<jsp:param value="<div id='chartContainer'>
		<div style='margin-left:30px;'><p><h6>1. Check out in menu Search service -> Search</h6></p>
		<p><h6>2. Test service</h6></p></div><br><br>
		<div style='margin-left:30px;'>Used techology</div>
		<ol>
			<li>Servlet, JSP engine search logic</li>
			<li>JS for menu (sidebar)</li>
			<li>Boostrap</li>
			<li>Maven</li>
			<li>Git</li>
			<li>Tomcat 8</li>
			<li>JPA Hibernate, Hiberate criteria</li>
			<li>H2 Embed</li>
		</ol>
		
		</div>" name="content"/>
	</jsp:include>
</body>
</html>