<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="<%= request.getContextPath() %>/style/vgb.css" rel="stylesheet">
		<title>99乘法表</title>
		<style>
			#table99 {
			  border-collapse: collapse;
			  width: 100%;
			}
			
			#table99 td, #table99 th {
			  border: 1px solid #ddd;
			  padding: 8px; text-align: center;
			}
			
			#table99 tr:nth-child(even){background-color: #f2f2f2;}
			
			#table99 tr:hover {background-color: #ddd;}
			
			#table99 caption {
			  padding-top: 12px;
			  padding-bottom: 12px;			  
			  background-color: #04AA6D;
			  color: white;
			}
		</style>
	</head>
<body>

	<table id='table99'>
		<caption>99乘法表</caption>
		<% for(int i=1;i<10;i++){%>
		<tr>
			<% for(int j=1;j<10;j++){%>
			<td><%= i %>*<%= j %>=<%= i*j %></td>
			<% } %>
		</tr>
		<% } %>		
	</table>


	<%
		for(int i=1;i<10;i++){
			for(int j=1;j<10;j++){%>
				<p><%=(i + "*" + j + "=" + i*j) %></p>
	<%		}
		}	
	%>
</body>
</html>