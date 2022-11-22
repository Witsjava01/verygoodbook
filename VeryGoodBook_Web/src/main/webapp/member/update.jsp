<%@page import="uuu.vgb.entity.VIP"%>
<%@page import="uuu.vgb.entity.Customer"%>
<%@ page pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/style/vgb.css">
		<title>非常好書 會員修改</title>		
		<style>
			article{min-height: 70vh}
			.memberForm{margin: auto;min-width: 20em;display: block;width: 50%;}
			#captchaImg{vertical-align: middle;}
			#refreshIcon{width: 22px;vertical-align: middle}
			
			footer{text-align:center;}			
			.memberForm label{display:inline-block;min-width:5.5ex}
			.errors{color:red}
		</style>
		<script src="https://code.jquery.com/jquery-3.0.0.js" 
			integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
			crossorigin="anonymous"></script>
		<script>
			function changePwdDisplay() {
				//alert(displayPwd.checked);
				if (displayPwd.checked){
					pwd1.type="text";
					pwd2.type="text";
				}else{
					pwd1.type="password";
					pwd2.type="password";
				}
			}
			
			function changePasswordOrNot(theCheckbox){				
					$("#pwd1").prop("disabled", !$(theCheckbox).prop("checked"));
					$("#pwd2").prop("disabled", !$(theCheckbox).prop("checked"));					
					$("#pwd1").prop("required", $(theCheckbox).prop("checked"));
					$("#pwd2").prop("required", $(theCheckbox).prop("checked"));
			}
			
			function refreshCaptcha(){
				//alert("refresh captcha"); //for test
				captchaImg.src="../images/captcha_register.png?test=" + parseInt(new Date().getTime()/1000);
			}	
			
			$(document).ready(init);
			
			function init(){
				repopulateForm();
			}
			
			function repopulateForm(){
				<% if("POST".equals(request.getMethod())){%>
					//alert("POST");					
					$("input[name='userid']").val('${param.userid}');					
					$("input[name='name']").val('<%= request.getParameter("name")%>');
					$("input[name='changePassword']").prop('checked',<%= request.getParameter("changePassword")!=null%>);
					<% if( request.getParameter("changePassword")!=null) {%>
						changePasswordOrNot(changePwd);
					<%}%>
					$("input[name='password1']").val('<%= request.getParameter("password1")%>');
					$("input[name='password2']").val('<%= request.getParameter("password2")%>');
					$("input[name='email']").val('<%= request.getParameter("email")%>');
					$("input[name='birthday']").val('<%= request.getParameter("birthday")%>');
					$("textarea[name='address']").val('<%= request.getParameter("address")%>');
					$(".gender[value='<%= request.getParameter("gender")%>']").prop('checked', true);
					$("input[name='phone']").val('<%= request.getParameter("phone")%>');					
					$("select[name='bloodType']").val('<%= request.getParameter("bloodType")%>');
					$("input[name='subscribed']").prop('checked', <%= request.getParameter("subscribed")!=null%>);					
				<%}else{
					Customer member = (Customer)session.getAttribute("member");
					if(member!=null){
				%>
					//$("input[name='userid']").val('<%= member.getId()%>');
					$("input[name='userid']").val('${sessionScope.member.id}');
					
					$("input[name='name']").val('<%= member.getName()%>');
					$("input[name='password1']").val('');
					$("input[name='password2']").val('');
					$("input[name='email']").val('${sessionScope.member.email}');
					$("input[name='birthday']").val('${sessionScope.member.birthday}');
					$("textarea[name='address']").val('${sessionScope.member.address}');
					$(".gender[value='<%= member.getGender()%>']").prop('checked', true);
					$("input[name='phone']").val('<%= member.getPhone()%>');					
					<%-- $("select[name='bloodType']").val('${sessionScope.member.bloodType}'); --%>
					$("input[name='subscribed']").prop('checked', <%= member.isSubscribed() %>);
					<%
					if(member instanceof VIP){
					%>
					$("#discountSpan").html("<input type='checkbox' disabled checked><label>"
								+	"VIP 享有<%= ((VIP)member).getDiscountString() %>"
								+	"</label>")
					<%}%>
				<%}else{%>
					alert('請先登入!');
				<%}}%>
			}
		</script>
	</head>
<body>
	<jsp:include page="/subviews/header.jsp">
		<jsp:param value="會員修改" name="subheader"/>
	</jsp:include>
	<%@ include file='/subviews/nav.jsp' %>
	<%
		List<String> errors = (List<String>)request.getAttribute("error");
	%>
	<article>		
		<form class='memberForm' method="POST" action="update.do">
		<p class='errors'><%= errors!=null?errors:"" %></p>
		<%-- 
			<ul class='errors'>
				<% 
				if(errors!=null && errors.size()>0){
					for(int i=0;i<errors.size();i++){
						String msg = errors.get(i);
				%>
					<li><%=msg %></li>
				 <%	}
				} %>				
			</ul>
		--%>			
			<p>
				<label>帳號: </label>
				<input name='userid' maxlength="10" readonly>
				<span id='discountSpan'></span>
			</p>
			<p>
				<label>姓名: </label>
				<input name='name' placeholder="輸入姓名" minlength='<%= Customer.MIN_NAME_LENGTH%>' maxlength="<%= Customer.MAX_NAME_LENGTH %>" required>
			</p>
			<p>
				<label>密碼: </label>
				<input type='password' name='password' placeholder="輸入現在的密碼" required>
			</p>
			<p>
				<fieldset>
				<legend><input type='checkbox' id='changePwd' name='changePassword' onchange='changePasswordOrNot(this)'>我要改密碼</legend>
				<label>新密碼: </label>
				<input type='password' id='pwd1' name='password1' placeholder="輸入新密碼" disabled 	 
					maxlength="<%= Customer.MAX_PASSWORD_LENGTH %>" minlength="<%= Customer.MIN_PASSWORD_LENGTH %>"><br>
				<label>確認: </label>
				<input type='password' id='pwd2' name='password2' placeholder="輸入確認密碼" disabled 
					maxlength="<%= Customer.MAX_PASSWORD_LENGTH %>" minlength="<%= Customer.MIN_PASSWORD_LENGTH %>">
				<input type='checkbox' id='displayPwd' onchange="changePwdDisplay()"><lable>顯示密碼</lable>
				</fieldset>
			</p>
			<p>
				<label>email: </label>
				<input type='email' name='email' required>
			</p>
			<p>
				<label>生日: </label>
				<input type='date' name='birthday' required>
			</p>			
			<p>
				<label>性別: </label>
				<input class='gender' type='radio' name='gender' required value="M"><label>男</label>
				<input class='gender' type='radio' name='gender' required value="F"><label>女</label>
				<input class='gender' type='radio' name='gender' required value="O"><label>其他</label>
			</p>
			<p>
				<label>地址: </label>
				<textarea name='address'></textarea>
			</p>
			<p>
				<label>電話: </label>
				<input type='tel' name='phone' >
			</p>
			<p>
				<label>血型: </label>
				<select name='bloodType'>
					<option value=''>請選擇...</option>					
					<option value='O'>O型</option>
					<option value='A'>A型</option>
					<option value='B'>B型</option>
					<option value='AB'>AB型</option>					
				</select>
				<input type='checkbox' name='subscribed'><label>訂閱電子報</label>
			</p>
			<p>
					<label>驗證: </label>
					<input type='text' name='captcha' placeholder="依據圖片輸入驗證碼" required><br>
					<a title='點選即可更新圖片' href='javascript:refreshCaptcha()'>
						<img id="captchaImg" src="../images/captcha_register.png" alt="驗證碼圖片">
					</a>
				</p>								
			<input type='submit' value='確定修改'>				
		</form>
	</article>
	<%@ include file='/subviews/footer.jsp' %>
</body>
</html>