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
	<jsp:param value="<div id='chartContainer'>
										<form method='post' name='frm' action='${pageContext.request.contextPath}/search-service/test'>
									    
									      <table border='0' width='300' align='center' bgcolor='#e9f' style='border-spacing: 9px; border-collapse:separate;'>
									        <tr>
									        	<td ><b>Category:</b></td>
									        	<td ><b>Product:</b></td>
									        	<td ><b>Cost from:</b></td>
									        	<td ><b>Cost to:</b></td>
											</tr>
											<tr>
												<td><input  type='text' name='cat' id='cat'></td>
												<td><input  type='text' name='product' id='product'></td>
												<td><input  type='text' name='salary_min' id='salary_min'></td>
												<td><input  type='text' name='salary_max' id='salary_max'></td>
												<td><input  type='submit' name='submit' value='Search'></td>
											</tr>
									      </table>
									    </form>
										<hr>
										
										
										<legend style='margin-left:15px;'>Result List</legend>
										<div class='table-responsive'>
											<table style='width:70%'  align='center' class='table table-striped table-bordered'>							
											<thead>
												<tr>
													<th>Category</th>
													<th>Product name</th>
													<th>Cost</th>
												</tr>
											</thead>
											<tbody>
												
				 								<tr>
				 								 <td>teter</td>
				 								 <td>teter</td>
				 								 <td>teter</td>
				 								</tr>
				 								<tr>
				 								 <td>teter2</td>
				 								 <td>teter2</td>
				 								 <td>teter2</td>
				 								</tr>
				 								<tr>
				 								 <td>teter3</td>
				 								 <td>teter3</td>
				 								 <td>teter3</td>
				 								</tr>
											</tbody>
										</table>
										</div>
					  </div>
	
	
	" name="content"/> 	
</jsp:include>

 <br/><br/>
 
					
    
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
