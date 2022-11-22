<%@page import="java.util.List"%>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="style/vgb.css" rel="stylesheet">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta charset="UTF-8">
		<title>會員登入</title>
		<style>
			#memberForm{width:60%;margin: auto;min-width: 480px}
			#memberForm label{display:inline-block;min-width: 3.25em}
			.errorMsg{color:darkred}	
			button[type='submit'] {font-family: 'Noto Sans TC', sans-serif;}	
		</style>
		<script>
			function displayPassword(thisCheckBox){
				console.log(thisCheckBox.checked); //for test
				if(thisCheckBox.checked){
					pwd.type='text';
				}else{
					pwd.type='password';
				}				
			}
			
			function refreshCaptcha(){				
				console.log(captchaImage.src);				
				captchaImage.src = 'images/captcha.png?xyz=' + new Date();
			}
		</script>
	</head>
	<body>
		<header>
			<h2>
				<a href='./'>非常好書</a> <sub>會員登入</sub> 
			</h2>
		</header>
		<nav>
			<a href="login.jsp">登入</a> |
			<a href='register.jsp'>註冊</a> |
			<hr>
		</nav>
		<%
			List<String> errorsList = (List<String>)request.getAttribute("error");
		%>
		<article>			
			<form id='memberForm' method='post' action='login.do'>
			<div class='errorMsg'><%= errorsList!=null?errorsList:"" %></div>			
				<p>
					<label for='id'>帳號:</label>
					<input type='text' id='id' name='id' placeholder="請輸入id或email" required>
					<input type="checkbox" name="auto" value='ON' ${cookie.auto.value}/>記住我的帳號
				</p>				
	   		<p>
					<label for='pwd'>密碼:</label>
					<input type='password' id='pwd' name='password' placeholder="請輸入密碼" required>
					<input type='checkbox' id='changePwdStatus' onchange="displayPassword(this)"><label>顯示密碼</label>
				</p>
				<p>
					<label for='captcha'>驗證碼:</label>
					<input type='text' id='captcha' name='captcha' placeholder="請輸入驗證碼" required autocomplete="off">
					<a href='javascript:refreshCaptcha()' >
						<img id='captchaImage' src='images/captcha.png' style='vertical-align:middle;' title='點選即可更新圖片'>
					</a>
				</p>
				<button type='submit'>登入</button>
<!-- 			<input type='submit' value='登入'>		 -->				
			</form>	
		</article>
		<footer>
			<hr>			
			<div >非常好書 &copy; 2022/07~</div>
		</footer>
	</body>
</html>