<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="task.from.intelligence.listener.LocalEntityManagerFactory"%>
<%@page import="task.from.intelligence.entity.Cat"%>
<%@page import="javax.persistence.TypedQuery"%>
<%@page import="java.util.List"%>


<jsp:include page="../WEB-INF/pages/template.jsp">
	<jsp:param value="Search Service" name="pageTitle"/>
	<jsp:param value="<div id='chartContainer'/>" name="content"/> 	
</jsp:include>


<%
					 
					 EntityManager em = LocalEntityManagerFactory.createEntityManager();
	                 try {
	                	 TypedQuery<Cat> namedQuery = em.createNamedQuery("Cat.getAll", Cat.class);
	                     List<Cat> cats =  namedQuery.getResultList();
	                     for(Cat cat : cats){
					 %>
					 	 <%=cat.getId()%><%=cat.getName()%><%=cat.getProducts()%><br>
				     <%}
	                 } finally {
	                      em.close();
	                 }
%>
