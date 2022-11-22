<%@page import="java.util.Set"%>
<%@page import="uuu.vgb.entity.Color"%>
<%@page import="java.util.Map"%>
<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.entity.Product"%>
<%@page import="uuu.vgb.service.ProductService"%>
<%@ page pageEncoding="UTF-8"%>	
<!-- product_ajax.jsp start -->
	<style>	
		.productDiv{min-width:85%;max-width: 85em;margin: auto}
		.productDiv>img{width:50%;display:inline-block;float:left;
			min-width:150px;max-width:300px;margin:1ex}
		.productDesc{clear:both}
		.productDesc{margin: 2ex 1ex;max-width: 85em;min-width:20em;width:85%}
		.productDesc p{white-space: pre-wrap;}
		
		.colorDiv{line-height: 4em;white-space:nowrap;}
		.colorDiv .iconImg{width:36px;vertical-align: middle;box-shadow:gray 0 0 3px}
		/* HIDE color RADIO */
		.colorDiv [type=radio] { 
		  position: relative;top:2px;opacity: 0;width: 1px;height: 1px;
		}
		
		/* IMAGE STYLES */
		.colorDiv [type=radio] + img {
		  cursor: pointer;
		}
		
		/* CHECKED STYLES */
		.colorDiv [type=radio]:checked + img {
		  outline: 2px solid #f00;
		}	
		
		input[type="image"]{width:30px;vertical-align: middle;}
	</style>
	<script>
		function changeImage(theIcon){
			console.log(photo.src);
			console.log(theIcon.dataset.photo);
			photo.src=theIcon.dataset.photo;//改圖片
			
			stockSpan.innerHTML="," + theIcon.title + " " +theIcon.dataset.stock;//改庫存
			quantity.max=theIcon.dataset.stock;//改數量input的max
		}
	</script>
	
		<%
			String productId = request.getParameter("productId");
			ProductService service = new ProductService();
			Product p = null;
			if(productId!=null){
				p = service.getProductById(productId);
			}		
		%>			
			<% if(p==null) {%>
				<p>查無此產品(<%= productId %>)</p>
			<%}else{ %>
			<div class='productDiv'>
				<img id='photo' src='<%=p.getPhotoUrl()%>' onerror='getBookImage(this)'>
				<h3><%=p.getName()%></h3>
				<% if(p instanceof Outlet){%>
				<div>定價：<%= ((Outlet)p).getListPrice() %>元</div>
				<div>折扣: <%= ((Outlet)p).getDiscountString() %> </div>
				<%} %>
				<div>優惠價: <%=p.getUnitPrice()%>元</div>
				<div>庫存: <%=p.getStock()%><span id='stockSpan'></span></div>	
				<form method='POST' action='add_cart.do'>
					<input type="hidden" name='productId' value='${param.productId}'>
					<% if(p.isColorful()) {%>
				    <div class='colorDiv'>
					    <label>顏色:</label>
					    <% 
					    	Map<String, Color> map = p.getColorsMap();
							Set<String> colorNameSet = map.keySet();
							
							for(String colorName:colorNameSet){
								Color color = map.get(colorName);
					    %>
					    <label>
							<input type='radio' name='color' required value="<%= colorName %>" required>
							<img class='iconImg' onclick='changeImage(this)' data-stock='<%= color.getStock() %>' title='<%= color.getColorName() %>'
								 src='<%= color.getIconUrl() %>'
								 data-photo='<%= color.getPhotoUrl() %>'
								>
						</label>
						<% } %>						
					</div>
					<div>
						<label>Size:</label>
						<select name='size'>
							<option value=''>無</option>
							<option value='S'>S</option>
							<option value='M'>M</option>
							<option value='L'>L</option>
						</select>
					</div>
					<% } %>					
					<div>
					    <label>數量: </label>
						<input type='number' id='quantity' name='quantity' required min='1' max='<%=p.getStock()%>'>
						<input type="image" src="images/add_cart.png" alt="加入購物車">
					</div>
					
				</form>	
				<div class='productDesc'>
				<% if(p.getDescription()!=null && p.getDescription().length()>0) {%>
				<hr>
				<% }%>
					<p><%=p.getDescription() %></p>
				</div>				
			</div>
			<%}%>		
<!-- product_ajax.jsp end -->			