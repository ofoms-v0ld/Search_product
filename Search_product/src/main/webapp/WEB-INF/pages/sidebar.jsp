<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div id="sidebar" class="sidebar-toggle">
	<ul class="nav nav-sidebar">
		<li><a href="${pageContext.request.contextPath}"> <i class="fa fa-home" aria-hidden="true"></i>
				<span>Home</span>
		</a></li>
		
		<li role="separator" class="divider"></li>
		
		<li data-toggle="collapse" href="#features" aria-expanded="false" aria-controls="features">
			<a href="#"> <i class="fa fa-search" aria-hidden="true"></i> <span>Search service</span></a>
		</li>
		<li>
			<ul id="features" class="sub-menu collapse ${fn:contains(pageContext.request.requestURI,'features') ? 'in' : ''}">
				<li><a href="${pageContext.request.contextPath}/search-service/search.jsp">Search</a></li>
				<li><a href="${pageContext.request.contextPath}/features/export-chart.jsp">Export Chart as Image</a></li>
				<li><a href="${pageContext.request.contextPath}/features/event-handling.jsp">Event Handling</a></li>
				<li><a href="${pageContext.request.contextPath}/features/log-axis.jsp">Logarithmic Axis</a></li>
				<li><a href="${pageContext.request.contextPath}/features/date-time.jsp">Date-Time Axis</a></li>
				<li><a href="${pageContext.request.contextPath}/features/reverse-axis.jsp">Reverse Axis</a></li>
				<li><a href="${pageContext.request.contextPath}/features/striplines.jsp">StripLines</a></li>
				<li><a href="${pageContext.request.contextPath}/features/multiple-y-axis.jsp">Multiple Y Axis</a></li>
				<li><a href="${pageContext.request.contextPath}/features/multi-series-chart.jsp">Multiseries Charts</a></li>
			</ul>
		</li>
		<li role="separator" class="divider"></li>
	
		<li data-toggle="collapse" href="#how-to" aria-expanded="false" aria-controls="how-to">
			<a href="#"> <i class="fa fa-forumbee" aria-hidden="true"></i> <span>Something else</span></a>
	    </li>
		<li>
			<ul id="how-to" class="sub-menu collapse ${fn:contains(pageContext.request.requestURI,'how-to') ? 'in' : ''}">
				<li><a href="${pageContext.request.contextPath}/how-to/enable-disable-ds.jsp">Something else I</a></li>
                <li><a href="${pageContext.request.contextPath}/how-to/live-chart.jsp">Something else II</a></li>
                <li><a href="${pageContext.request.contextPath}/how-to/sync-multiple-charts.jsp">Something else III</a></li>
			</ul>
		</li>
		
		<li role="separator" class="divider"></li>
	</ul>
</div>