<%@ page language="java"
         contentType="text/html"
         isErrorPage="true"
%>
<%@ page import="java.util.*" %>
<%@page import="task.from.intelligence.entity.Cat"%>
<%@page import="task.from.intelligence.entity.Prod"%>
<%@page import="task.from.intelligence.bean.validation.SearchFormValidationBean"%>
<%@page import="task.from.intelligence.servlet.validation.ValidationException"%>
<%@page import="java.util.List"%>
<jsp:useBean id="searchFormValidationBean" scope="session" class="task.from.intelligence.bean.validation.SearchFormValidationBean" />

<%
	String msgMandatoryField = "";
	String msgException = "";
	
	// if there is an exception then the error must be shown.
	if (null != exception) {
	    // fill messages
	    ValidationException validationEx = (ValidationException) exception;
	    msgMandatoryField = validationEx.getMessage("msgMandatoryField");
	}

%>

<jsp:include page="../WEB-INF/pages/template.jsp">
	<jsp:param value="Search Service" name="pageTitle"/>
	<jsp:param value="" name="content"/> 	
</jsp:include>

<div class='page-content-toggle'>
										<form method='post' action='<%= request.getContextPath() %>/search-service/search' name='frm'>
									    
									      <table border='0' width='300' align='center' bgcolor='#e9f' style='border-spacing: 9px; border-collapse:separate;'>
									        <tr>
									        	<td ><b>Category:</b></td>
									        	<td ><b>Product:</b></td>
									        	<td ><b>Cost from:</b></td>
									        	<td ><b>Cost to:</b></td>
											</tr>
											<tr>
												<td><input  type='text' name='cat' id='cat' 
                   								value='<jsp:getProperty name='searchFormValidationBean' property='mandatoryTextField' />'>
                   								</td>
												<td><input  type='text' name='product' id='product'></td>
												<td><input  type='text' name='salary_min' id='salary_min'></td>
												<td><input  type='text' name='salary_max' id='salary_max'></td>
												<td><input  type='submit' name='submit' value='Search'></td>
											</tr>
											<tr>
												<td align='left'>
									            <font face='Verdana,Arial,Helvetica,sans-serif' size='2' color='red'>
									              <strong><%=msgMandatoryField%> &nbsp; </strong>
									            </font>
									          </td>
											</tr>
									      </table>
									    </form>
								  </div>
<hr>



<legend style='margin-left:15px;'>Result List</legend>
	<div class='page-content-toggle'>
		<table style='width:70%'  align='center' class='table table-striped table-bordered'>							
		<thead>
			<tr>
				<th>Category</th>
				<th>Product name</th>
				<th>Cost</th>
			</tr>
		</thead>
		<tbody>
		
		<!-- start scriplet -->
<%
try
 {
        List<Cat> list = (List) request.getAttribute("resultList");
        for(Cat cat : list) {
        	Set<Prod> set_prod = cat.getProducts();
        	for(Prod prod : set_prod){
%>
			<tr>
			<td><%=cat.getName() %></td>
			<td><%=prod.getName() %></td>
			<td><%=prod.getPrice() %></td>
			</tr>
			
<%			}	
		}
 }catch(Exception e)
 {
    e.printStackTrace();  
 }
%>
			<!-- end scriplet -->
			</tbody>
			</table>
			</div>       
