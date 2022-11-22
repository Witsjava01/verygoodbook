<%@ page pageEncoding="UTF-8"%>
	<!-- header.jsp start -->
		<header>
			<form style='float:right' method='GET' action='<%= request.getContextPath()%>/products_list.jsp'>
				<input type='search' name='keyword' value='${param.keyword}' placeholder="請輸入查詢條件...">
				<input type='submit' value='查詢'>
			</form>	
			<h2>
				<a href='<%= request.getContextPath()%>/'>非常好書</a> 
				<sub>
					<%--  <%= request.getParameter("subheader")==null?"Welcome":request.getParameter("subheader")%>--%>
					${param.subheader==null?"Welcome":param.subheader}
				</sub> 
			</h2>			
		</header>	
	<!-- header.jsp end -->	