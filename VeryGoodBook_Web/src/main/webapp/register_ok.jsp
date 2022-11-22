<%@page import="uuu.vgb.entity.Customer"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="style/vgb.css" rel="stylesheet">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="refresh" content="3;url=<%= request.getContextPath() %>/">
		<title>註冊成功</title>
	</head>
<body>
		<header>
			<h1 style='text-align: center'>
				<a href='<%= request.getContextPath() %>/'>非常好書</a> <sub>會員註冊成功</sub> 
			</h1>
		</header>
		<%
			Customer c = (Customer)request.getAttribute("customer");
		%>
		<article>
			<hr>
			<h2><%= c!=null?c.getName():"" %>註冊成功</h2>
			<p>3秒後將自動跳轉<a href='<%= request.getContextPath() %>'>首頁</a></p>
		</article>
		<footer>
			<hr>			
			<div >非常好書 &copy; 2022/07~</div>
		</footer>
</body>
</html>