<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>

<html>
<head>
<title>Home</title>

</head>
<body>
	<jsp:include page="/WEB-INF/pages/template.jsp">
		<jsp:param value="Hello my future employer!" name="pageTitle"/>
		<jsp:param value="<div id='chartContainer'/>" name="content"/>
	</jsp:include>
</body>
</html>