<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="<%= request.getContextPath() %>/style/vgb.css" rel="stylesheet">
		<title>歷史訂單</title>
		<style>
			#ordersTable {border-collapse: collapse;width: 80%;margin: auto;}
		
			#ordersTable caption {padding-top: 12px;padding-bottom: 12px;background-color: gray;color: white;}
			
			#ordersTable th {background-color: #e2e2e2;}			
			#ordersTable th,#cartTable td{border: 1px solid #d2d2d2;padding: 8px;}
			
			#ordersTable tbody img{width:48px;vertical-align: middle;}
			#ordersTable tbody tr td{padding:1ex}
			#ordersTable tr:nth-child(even){background-color:#f2f2f2;}			
			#ordersTable tr:hover {background-color: Lavender;}
		</style>
	</head>
<body>
<jsp:include page="/subviews/header.jsp" >
			<jsp:param value="歷史訂單" name="subheader"/>
		</jsp:include> 			
			
		<%@ include file="/subviews/nav.jsp" %>		
		<article>						
				<table id='ordersTable'>
					<caption>歷史訂單</caption>
					<!-- <colgroup>
    					<col span="4" style="text-align: center">
    					<col style="text-align: right">
    					<col style="text-align: center">
  					</colgroup> -->
					<thead>
						<tr>
							<th>No.</th><th>訂購日期時間</th>
							<th>付款方式</th><th>取貨方式</th><th>總金額</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>000015</td><td>2022-08-12 10:55</td><td>ATM</td>
							<td>超商取貨</td><td>1255</td>
							<td><a href='order.jsp?orderId=15'>檢視明細</a></td>
						</tr>
						<tr>
							<td>000001</td><td>2022-08-10 13:55</td>
							<td>ATM</td><td>超商取貨</td><td>200</td>
							<td><a href='order.jsp?orderId=1'>檢視明細</a></td>
						</tr>
					</tbody>
					</li>
				</table>
		</article>
		<%@ include file="/subviews/footer.jsp" %>
</body>
</html>



		
		