<%@page import="uuu.vgb.entity.Customer"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="<%= request.getContextPath() %>/style/vgb.css" rel="stylesheet">
		<title>非常好書首頁</title>
		<style></style>
		<script src="https://code.jquery.com/jquery-3.0.0.js" 
				integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
				crossorigin="anonymous"></script>
	
	</head>
	<body>
		<jsp:include page="/subviews/header.jsp" >
			<jsp:param value="首頁" name="subheader"/>
		</jsp:include>			
			
		<%@ include file="/subviews/nav.jsp" %>		
		<article>
			
		</article>
		<%@ include file="/subviews/footer.jsp" %>
	</body>
</html>



		
		