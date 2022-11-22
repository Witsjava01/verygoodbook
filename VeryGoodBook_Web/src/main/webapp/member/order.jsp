<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%= request.getContextPath() %>/style/vgb.css" rel="stylesheet">
<title>訂單明細</title>
<style type="text/css">
		#cartTable {border-collapse: collapse;width: 80%;margin: auto}

		#cartTable caption {padding-top: 12px;padding-bottom: 12px;background-color: orange;color: white;}
						
		#cartTable th {background-color: #e2e2e2;}			
		#cartTable th,#cartTable td{border: 1px solid #d2d2d2;padding: 8px;}
			
		#cartTable tbody img{width:48px;vertical-align: middle;}
		#cartTable tr:nth-child(even){background-color:#f2f2f2;}			
		#cartTable tr:hover {background-color: beige;}
			
		#cartTable tfoot tr{border: 1px solid #d2d2d2;}
		#cartTable tfoot td{border: none;}
		#cartTable tfoot tr.amount, #cartTable td.amount,#cartTable tfoot tr td:last-child{text-align: right}	
		input[type='number'].quantity{width:3em}
			
		#cartForm fieldset input[type='text']{width:70%}
</style>
</head>
<body>
<jsp:include page="/subviews/header.jsp" >
			<jsp:param value="訂單明細" name="subheader"/>
		</jsp:include> 
			
			
		<%@ include file="/subviews/nav.jsp" %>		
		<article>
		<div style='height: 30vh'>
		</div>
			
				<table id='cartTable'>
					<caption>訂單明細</caption>
					<thead>
						<tr>
							<th>No.</th>
							<th>名稱</th>						
							<th>顏色</th>						
							<th>Size</th>
							<th>定價</th>
							<th>折扣</th>
							<th>售價</th>
							<th>數量</th>
							<th>小計</th>							
						</tr>
					</thead>
					<tbody>
						
						<tr>
							<td>12</td>
							<td>
								<img src='https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/127/75/N001277566.jpg&w=348&h=348&v=603f2e52k'>
								[MUJI無印良品]水性繪筆
								<span style='font-size: smaller'>,庫存: 12</span>
							</td>	
							<td>芥黃</td>
							<td></td>					
							<td>39.00元</td>
							<td></td>
							<td>39.00元</td>
							<td>1</td>
							<td class='amount'>39.00元</td>							
						</tr>
						
						<tr>
							<td>12</td>
							<td>
								<img src='https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/N00/127/90/N001279019.jpg&v=6045db9ck&w=348&h=348'>
								[MUJI無印良品]水性繪筆
								<span style='font-size: smaller'>,庫存: 5</span>
							</td>	
							<td>紅</td>
							<td></td>					
							<td>39.00元</td>
							<td></td>
							<td>39.00元</td>
							<td>1</td>
							<td class='amount'>39.00元</td>							
						</tr>
						
						<tr>
							<td>1</td>
							<td>
								<img src='https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/092/37/0010923732.jpg&w=374&h=374&v=626bbe47'>
								Java SE 17 技術手冊
								<span style='font-size: smaller'>,庫存: 12</span>
							</td>	
							<td></td>
							<td></td>					
							<td>680.00元</td>
							<td>79折</td>
							<td>537.20元</td>
							<td>1</td>
							<td class='amount'>537.20元</td>							
						</tr>
																
					</tbody>
					<tfoot>
						<tr>										
							<td class='amount' colspan="5">共3項, 3件</td>
							<td class='amount' colspan="4">總金額為: <span id='totalAmountSpan'>615</span>元</td>					
						</tr>
					</tfoot>
				</table>		
		</article>
		<%@ include file="/subviews/footer.jsp" %>
</body>
</html>



		
		