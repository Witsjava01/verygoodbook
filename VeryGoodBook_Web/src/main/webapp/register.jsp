<%@page import="uuu.vgb.entity.Customer"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="<%= request.getContextPath() %>/style/vgb.css" rel="stylesheet">
		<title>會員註冊</title>
		<style>
				#memberForm{width:60%;margin: auto;min-width: 480px}
				#memberForm label{display:inline-block;min-width: 3.25em}
				#captchaImage{cursor: pointer;vertical-align: middle;}
		</style>
		<script src="https://code.jquery.com/jquery-3.0.0.js" 
				integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" 
				crossorigin="anonymous"></script>
		<script>
			$(document).on("click", "#captchaImage", refreshCaptcha);
			function refreshCaptcha(){
				console.log($(this).attr("src"));
				$(this).attr("src", "images/captcha_register.png?data=" + new Date());
			}
			
			$(init);
			function init(){
				//alert('init');
				repopulateForm();
			}
			
			function repopulateForm(){
				<% if("POST".equals(request.getMethod())) {%>				
				$("input[name='userid']").val('<%= request.getParameter("userid")%>');
				$("input[name='name']").val('<%= request.getParameter("name")%>');
				$("input[name='email']").val('<%= request.getParameter("email")%>');
				$("input[name='birthday']").val('<%= request.getParameter("birthday")%>');
				$("input[name='gender'][value='<%=request.getParameter("gender")%>']").prop("checked", true);
					
				$("textarea[name='address']").val('<%= request.getParameter("address")%>');
				$("input[name='phone']").val('<%= request.getParameter("phone")%>');
				$("input[name='subscribed']").prop("checked", <%= request.getParameter("subscribed")!=null%>);
				
				$("select[name='bloodType']").val('<%= request.getParameter("bloodType")%>');
				<%}%>
			}
			
			function displayPassword(thisCheckBox){
				console.log(thisCheckBox.checked); //for test
				if(thisCheckBox.checked){
					$("input[name='password1']").attr('type','text');
					$("input[name='password2']").attr('type','text');
				}else{
					$("input[name='password1']").attr('type','password');
					$("input[name='password2']").attr('type','password');
				}				
			}
		</script>	
	</head>
	<body>
		<jsp:include page="/subviews/header.jsp" >
			<jsp:param value="註冊" name="subheader"/>
		</jsp:include>	
		<%@ include file="/subviews/nav.jsp" %>	
		<%
		List<String> errorsList = (List<String>)request.getAttribute("error");
		%>
		<article>
			<form id='memberForm' action='register.do' method='POST'>
				<div><%= errorsList==null?"":errorsList %></div>
	                <p>
	                    <label>帳號:</label>
	                    <input name='userid' type='text' required pattern="[A-Z][12][0-9]{8}"
	                           placeholder='請輸入身分證號' value=''>
	                </p>
	                <p>
	                    <label>姓名:</label>
	                    <input name='name' type='text' required placeholder='請輸入姓名'>
	                </p>
	                <p>
	                    <label>密碼:</label>
	                    <input name='password1' type='password' placeholder='請輸入密碼(6~20個字)'
	                           minlength="6" maxlength="20" required><br>
	                    <label>確認:</label>
	                    <input name='password2' type='password' placeholder='請再確認密碼(6~20個字)'
	                           minlength="6" maxlength="20" required>
	                    <input type='checkbox' id='changePwdStatus' onchange="displayPassword(this)"><label>顯示密碼</label>
	                </p>
	                <p>
	                    <label>性別:</label>
	                    <input type='radio' name='gender' id='male' value="M" required><label for='male' required>男</label>
	                    <input type='radio' name='gender' id='female' value="F" required><label for='female' required>女</label>
	                    <input type='radio' name='gender' id='unknown' value="U" required><label for='unknown' required>不想透露</label>
	                </p>
	                <p>
	                    <label>Email:</label>
	                    <input name='email' type='email' required placeholder='請輸入Email' required>
	                </p>              
	                <p>
	                    <label>生日:</label>
	                    <input name='birthday' type='date' required max='2010-07-14' value='2000-02-05'>
	                </p>
	                
	                <p>
	                    <label>地址:</label>
	                    <textarea name='address'></textarea>
	                </p>                  
	                <p>
	                    <label>電話:</label>
	                    <input type='tel' name='phone'>
	                </p>
	                <p>
	                    <label>血型:</label>
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
	                    <img id="captchaImage" src='images/captcha_register.png' title='點選即可更新圖片'>	                    
	                    <input name='captcha' type='text' required style='width: 12em' autocomplete="off"
	                           placeholder='請依圖片內容輸入(不分大小寫)' required>                    
	                </p>
	                <input type='submit' value="確定">
	            </form>		
		</article>
		<%@ include file="/subviews/footer.jsp" %>
	</body>
</html>



		
		