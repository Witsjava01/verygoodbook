<%@page import="uuu.vgb.entity.Customer"%>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="style/vgb.css" rel="stylesheet">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv='refresh' 
			content="5;url=${empty requestScope['login.prev.uri']?pageContext.request.contextPath:requestScope['login.prev.uri']}">
		<meta charset="UTF-8">
		<title>登入成功</title>
		<script>
			window.setInterval()
		
		</script>
	</head>
	<body>
		<header>
			<h1 style='text-align: center'>
				<a href='<%= request.getContextPath()%>/'>非常好書</a> <sub>會員登入成功</sub> 
			</h1>
		</header>
		<%
			Customer member = (Customer)session.getAttribute("member");			
		%>
		<article>
			<hr>
			<h2><%= member!=null?member.getName():"XXX" %>登入成功</h2>
			<p><span id=secondSapn>5</span>秒後將自動跳轉<a href='<%= request.getContextPath()%>/'>指定網頁</a></p>
		</article>
		<footer>
			<hr>			
			<div >非常好書 &copy; 2022/07~</div>
		</footer>
</body>
</html>