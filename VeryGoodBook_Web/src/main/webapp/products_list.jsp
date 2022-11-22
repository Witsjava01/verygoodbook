<%@page import="uuu.vgb.entity.Outlet"%>
<%@page import="uuu.vgb.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="uuu.vgb.service.ProductService"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="<%= request.getContextPath() %>/style/vgb.css" rel="stylesheet">
		<link rel='stylesheet' type='text/css' 
			href='<%= request.getContextPath() %>/fancybox3/jquery.fancybox.css'>
		<title>逛書店</title>
		<style>
			.productsList{margin-left: 1ex;padding-left: 0;}
			.productItem{display: inline-block;width:275px;height: 280px; 
				vertical-align: top;box-shadow: lightgray 1px 2px 5px;padding:1ex;text-align: center }
			.productItem img{width:150px;display: block;margin: auto;}
			#productDetail{display:none;height:70vh;font-size: smaller;}
			.fancybox-is-open .fancybox-bg {opacity: .7;}
		</style>
		<script src="https://code.jquery.com/jquery-3.0.0.js" 
			integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
			crossorigin="anonymous"></script>		
		<script src='<%= request.getContextPath() %>/fancybox3/jquery.fancybox.js'></script>
		<script>		
			function getProductJSP(productId, cat){
				//作法1: 同步請求:
// 				var urlPath = 'product.jsp?productId=' + productId;
// 				alert(urlPath); //for test				
// 				location.href=urlPath;								
				
				//作法2: 非同步請求:
				var urlPath = 'product_ajax.jsp?productId=' + productId; // + "&cat=" + cat;
				$.ajax({
					url: urlPath,
					method:'GET'					
				}).done(getProductJSPDoneHandler);
			}
			
			function getProductJSPDoneHandler(response){
				//console.log(response);				
				//用fancybox3顯示
				$('#productDetail').html(response);
				$.fancybox.open({
				    src  : '#productDetail',
				    type : 'inline',
				    opts : {
				      afterShow : function( instance, current ) {
				        console.info('done!');
			      	  }
			    	}
			  	});
			}
			
			function getBookImage(theImage){
				$(theImage).attr('src', '<%= request.getContextPath() %>/images/book.png')
			}
		</script>
	</head>
	<body>		
		<div id='productDetail'></div>
		<jsp:include page="/subviews/header.jsp" >
			<jsp:param value="逛書店" name="subheader"/>
		</jsp:include> 
		<%@ include file="/subviews/nav.jsp" %>		
		<div>
			<a href="?">全部</a>
			<a href="?category=書籍#test1">書籍</a>
			<a href="?category=文具#test2">文具</a>
		</div>	
		<%
			String category = request.getParameter("category");
			String keyword = request.getParameter("keyword");
			ProductService service = new ProductService();
			List<Product> list = null;
			if(category!=null){
				list = service.getProductsByCategory(category);
			}else if(keyword!=null && keyword.length()>0){
				list = service.getProductsByName(keyword);
			}else{
				list = service.getAllProducts();
			}
		%>	
		<article>
			<%if(list==null || list.size()==0) {%>
				<p>查無產品資料!</p>
			<%}else{%>			
			<ul class='productsList'>
				<% for(int i=0;i<list.size();i++){
					Product p = list.get(i);
				%>							
				<li class='productItem'>
					<a href='javascript:getProductJSP("<%= p.getId() %>", "<%= p.getCategory()%>")'>
						<img src='<%= p.getPhotoUrl() %>' onerror='getBookImage(this)'>
					</a>
					<a href='product.jsp?productId=<%= p.getId() %>'>
						<h4><%= p.getName() %></h4>
					</a>
					<div>優惠價: <%= p instanceof Outlet?((Outlet)p).getDiscountString():"" %> <%=p.getUnitPrice() %>元</div>
					<div>庫存: <%=p.getStock() %></div>
				</li>
				<% } %>				
			</ul>
			<% } %>
		</article>
		<%@ include file="/subviews/footer.jsp" %>		
	</body>
	
</html>



		
		