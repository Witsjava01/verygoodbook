<%@page import="uuu.vgb.entity.CartItem"%>
<%@page import="uuu.vgb.entity.ShoppingCart"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="widtd=device-widtd, initial-scale=1.0">
<link href="<%= request.getContextPath() %>/style/vgb.css" rel="stylesheet">
<title>購物車</title>
	<style>
			#cartTable {border-collapse: collapse;width: 80%;margin: auto}

			#cartTable caption {padding-top: 12px;padding-bottom: 12px;background-color: #04AA6D;color: white;}
						
			#cartTable th {background-color: #e2e2e2;}			
			#cartTable th,#cartTable td{border: 1px solid #d2d2d2;padding: 8px;}
			
			#cartTable tbody img{width:48px;vertical-align: middle;}
			#cartTable tr:nth-child(even){background-color:#f2f2f2;}			
			#cartTable tr:hover {background-color: beige;}
			#cartTable tbody{font-size: smaller;}
			
			#cartTable tfoot tr{border: 1px solid #d2d2d2;}
			#cartTable tfoot td{border: none;}
			#cartTable tfoot tr.amount, #cartTable td.amount,#cartTable tfoot tr td:last-child{text-align: right}	
			#cartTable tfoot td.listprice {text-decoration:line-through;color:#d57676;font-size: smaller}
			input[type='number'].quantity{width:3em}
						
		</style>
</head>
<body>
		<jsp:include page="/subviews/header.jsp" >
			<jsp:param value="購物車" name="subheader"/>
		</jsp:include>
		<%@ include file="/subviews/nav.jsp" %>		
		<article>
			<%-- ${sessionScope.cart} --%>
			<%
				ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");				
				if(cart==null || cart.isEmpty()){
			%>	
				<h3>購物車是空的!</h3>		
			<%  }else{ 
				if(member!=null) cart.setMember(member);
			%>
			<form method='POST' action='update_cart.do' id='cartForm'>
				<table id='cartTable'>
					<caption>購物車明細</caption>
					<thead>
						<tr>							
							<th>名稱</th>						
							<th>顏色/Size</th>
							<th>定價</th>
							<th>折扣</th>
							<th>售價</th>
							<th>數量</th>
							<th>小計</th>
							<th>刪除?</th>
						</tr>
					</thead>
					<tbody>
						<% for(CartItem item:cart.getCartItemsSet()){
							int stock=item.getStock();
							%>
						<tr>							
							<td>
								<img src='<%= item.getPhotoUrl() %>'>
								<%= item.getProductName() %>
								<span style='font-size: smaller'>,庫存: <%= stock %></span>
							</td>	
							<td>
								<%= item.getColorName() %>
								<%= item.getSizeName() %>
							</td>					
							<td><%= cart.PRICE_FORMAT.format(item.getListPrice()) %>元</td>
							<td><%= cart.getDiscountString(item) %></td>
							<td><%=  cart.PRICE_FORMAT.format(cart.getUnitPrice(item)) %>元</td>
							<td><input class='quantity' type='number' name='quantity<%= item.hashCode() %>' value='<%= cart.getQuantity(item) %>'"
									 required min='1' max='<%= stock %>'>								
							</td>
							<td class='amount'><%=  cart.PRICE_FORMAT.format(cart.getAmount(item)) %>元</td>
							<td>
								<input type='checkbox' name='delete<%= item.hashCode() %>'>
							</td>
						</tr>
						<% } %>										
					</tbody>
					<tfoot>
						<tr>										
							<td class='amount' colspan="1">共<%= cart.size() %>項, <%= cart.getTotalQuantity() %>件</td>
							<td class='amount listprice' colspan="3">
								原價總額為: <%= cart.AMOUNT_FORMAT.format(cart.getTotalListAmount()) %>元</td>
							</td>
							<td class='amount' colspan="4">
								總金額為: <%= cart.AMOUNT_FORMAT.format(cart.getTotalAmount()) %>元</td>											
						</tr>	
						<tr>										
							<td colspan="2"><input type='button' value='回書店繼續購物' 
								onclick='location.href="../products_list.jsp"'></td>
							<td colspan="6">
								<input type='submit' name='submit' value='修改購物車'>				
								<button name='submit' value='checkout'>去結帳</button>
							</td>
						</tr>								
					</tfoot>
				</table>
			</form>
			<% } %>
		</article>
		<%@ include file="/subviews/footer.jsp" %>
</body>
</html>



		
		