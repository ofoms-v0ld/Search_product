<%@ page language="java"
         contentType="text/html"
         import="task.from.intelligence.servlet.validation.ValidationException"
         isErrorPage="true"
%>
<%
    ValidationException valEx = (ValidationException)exception;
    String errorPage = valEx.getErrorPage();
    if (null != errorPage)
        pageContext.forward(errorPage);
    else
        throw new ServletException("ErrorPage not set", valEx);
%>