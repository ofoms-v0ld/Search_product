<%@ page language="java"
         contentType="text/html"
         isErrorPage="true"
%>
<%@ page import="java.util.*" %>
<%@page import="task.from.intelligence.entity.Cat"%>
<%@page import="task.from.intelligence.pojo.Prod_pojo"%>
<%@page import="task.from.intelligence.entity.Prod"%>
<%@page import="task.from.intelligence.bean.validation.SearchFormValidationBean"%>
<%@page import="task.from.intelligence.servlet.validation.ValidationException"%>
<%@page import="java.util.List"%>
<jsp:useBean id="searchFormValidationBean" scope="session" class="task.from.intelligence.bean.validation.SearchFormValidationBean" />

<%
	String msgMandatoryField = "";
	String msgException = "";
	String cat_if = request.getParameter("cat"); 	if(cat_if == null) cat_if ="";
	String product_if = request.getParameter("product");	if(product_if == null) product_if ="";
	String cost_min_if = request.getParameter("salary_min");	if(cost_min_if == null) cost_min_if ="";
	String cost_max_if = request.getParameter("salary_max");	if(cost_max_if == null) cost_max_if ="";
	
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
										<form method='post' action='<%=request.getContextPath() %>/search-service/search' name='frm'>
									    
									      <table border='0' width='300' align='center' bgcolor='#e9f' style='border-spacing: 9px; border-collapse:separate;'>
									        <tr>
									        	<td ><b>Category:</b></td>
									        	<td ><b>Product:</b></td>
									        	<td ><b>Cost from:</b></td>
									        	<td ><b>Cost to:</b></td>
											</tr>
											<tr>
												<td><input  type='text' name='cat' id='cat' 
                   								value='<%=cat_if %>'>
                   								</td>
												<td><input  type='text' name='product' id='product' value='<%=product_if %>'></td>
												<td><input  type='text' name='salary_min' id='salary_min' value='<%= cost_min_if%>'></td>
												<td><input  type='text' name='salary_max' id='salary_max' value='<%= cost_max_if%>'></td>
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
        List<Prod_pojo> list = (List) request.getAttribute("resultList");
        for(Prod_pojo cat : list) {
%>
			<tr>
			<td><%=cat.getCatname() %></td>
			<td><%=cat.getProdname() %></td>
			<td><%=cat.getProdprice() %></td>
			</tr>
			
<%				
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
