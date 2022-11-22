<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.entity.Product"%>
<%@page import="uuu.vgb.service.ProductService"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%= request.getContextPath() %>/style/vgb.css" rel="stylesheet">
<title>產品介紹</title>
<style>
	.productDiv{max-width: 85em;margin: auto}
	.productDiv img{width:45%;display:inline-block;float:left;min-width:180px;max-width: 350px;margin:1ex}
	.productDesc{clear:both}
	.productDesc{margin: 2ex 1ex;}
	.productDesc p{white-space: pre;}
</style>
</head>
<body>
		<jsp:include page="/subviews/header.jsp" >
			<jsp:param value="產品介紹" name="subheader"/>
		</jsp:include>
			
		<%@ include file="/subviews/nav.jsp" %>
		<%
			String productId = request.getParameter("productId");
			ProductService service = new ProductService();
			Product p = null;
			if(productId!=null){
				p = service.getProductById(productId);
			}		
		%>	
			
		<article>
			<% if(p==null) {%>
				<p>查無此產品(<%= productId %>)</p>
			<%}else{ %>
			<div class='productDiv'>
				<img src='<%=p.getPhotoUrl()%>'>
				<h3><%=p.getName()%></h3>
				<% if(p instanceof Outlet){%>
				<div>定價：<%= ((Outlet)p).getListPrice() %>元</div>
				<div>折扣: <%= ((Outlet)p).getDiscountString() %> </div>
				<%} %>
				<div>優惠價: <%=p.getUnitPrice()%>元</div>
				<div>庫存: <%=p.getStock()%></div>			
				<form method='POST'>
					<input type="hidden" name='productId' value='${param.productId}'>
					<div>
					    <label>數量: </label>
						<input type='number' name='quantity' required min='1' max='<%=p.getStock()%>'>
					</div>
				    <!-- 	<div>
					    <label>顏色: </label>
						<input type='radio' name='quantity' required min='1' max='12' value="紅" required><label>紅</label>
						<input type='radio' name='quantity' required min='1' max='12' value="黃" required><label>黃</label>
						<input type='radio' name='quantity' required min='1' max='12' value="藍" required><label>藍</label>
					</div> -->
					<input type='submit' value='加入購物車'>
				</form>	
				<div class='productDesc'>
				<hr>
					<p><%=p.getDescription() %></p>
				</div>				
			</div>
			<%}%>
		</article>
		<%@ include file="/subviews/footer.jsp" %>
</body>
</html>



		
		