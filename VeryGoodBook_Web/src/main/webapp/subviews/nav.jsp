<%@page import="uuu.vgb.entity.Customer"%>
<%@ page pageEncoding="UTF-8"%>
	<!-- nav.jsp start -->
		<% //取得登入的會員
			Customer member = (Customer)session.getAttribute("member");		
		%>
		<nav>
 			<a href="<%= request.getContextPath()%>/products_list.jsp">書店</a> | 
 			<!-- 			<a href='#'>Book</a> | -->
<!-- 			<a href='#'>文具</a> | -->
			<% if(member==null) {%>
			<a href="<%= request.getContextPath()%>/login.jsp">登入</a> |
			<a href='<%= request.getContextPath()%>/register.jsp'>註冊</a> |
			<% }else{%>
			<a href="<%= request.getContextPath()%>/member/order_history.jsp">歷史訂單</a> |
			<a href="<%= request.getContextPath()%>/member/update.jsp">修改會員</a> |
			<a href='logout.do'>登出</a> |
			<% }%>			
			<span style='float:right'>
				<a href='<%= request.getContextPath()%>/member/cart.jsp'>
					<image class='cartIcon' src='<%=request.getContextPath()%>/images/cart_icon.png'></a>
				<span class='totalQtySpan'>${sessionScope.cart.totalQuantity}</span>
				<%= member!=null?member.getName():"" %> 你好
			</span>
			<hr>
		</nav>
	<!-- nav.jsp end -->