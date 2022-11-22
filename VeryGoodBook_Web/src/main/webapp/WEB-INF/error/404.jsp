<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%= request.getContextPath() %>/style/vgb.css" rel="stylesheet">
<title>找不到檔案</title>
</head>
<body>
	<jsp:include page="/subviews/header.jsp" >
			<jsp:param value="系統發生錯誤" name="subheader"/>
		</jsp:include> 
<!-- 		<a href='../../abc'>abc</a> -->
			
		<%@ include file="/subviews/nav.jsp" %>		
		<article>
				<%
					String msg=null;
					int errorCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
					switch(errorCode){
						case 404: msg="找不到檔案";break;
						case 405: msg="不支援這個請求方式:" + request.getMethod();break;						
					}
				%>
				<h1>錯誤代號: <%= response.getStatus() %></h1>
				<h2><%= msg!=null?msg:request.getAttribute("javax.servlet.error.message") %></h2>
				<div>網址:<%= request.getAttribute("javax.servlet.error.request_uri") %></div>		
		</article>
		<%@ include file="/subviews/footer.jsp" %>
</body>
</html>



		
		