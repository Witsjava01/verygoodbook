<%@page import="java.util.Date"%>
<%@page import="java.util.Random"%>
<%@page import="java.io.PrintWriter"%>
<%@page pageEncoding="UTF-8" buffer="8kb" autoFlush="true"%>
<%!
	private int i=100; //屬性
	
	public void jspInit(){
		this.log("Test");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%= request.getContextPath() %>/style/vgb.css" rel="stylesheet">
<title>隱含變數示範</title>
<style>
	/* 測試 */
	p {color:blue}
	p label{color:black}
	h3 sup{color:red}
</style>

</head>
<body>
	<header>
		<h2>隱含變數(Implicit Variables)示範</h2>
	</header>
	<hr>
	 
<%-- 	<p>
	<%
		jspInit(new PrintWriter(out));
	%>
	</p> --%> 
	<%
		int i = 1; //區域變數		
	%>
	<p>i/this.i: <%= i/this.i %></p>
	<hr>
	<h3>request <sup>***</sup></h3>
	<p><label>contextPath(Context Root):</label> <%= request.getContextPath() %></p>
	<p><label>requestURL:</label><%= request.getRequestURL() %></p>
	<p><label>method:</label><%= request.getMethod() %></p>
	<p><label>protocol:</label><%= request.getProtocol() %></p>
	<p><label>server name:</label><%= request.getLocalName() %></p>
	<p><label>server ipAddress:</label><%= request.getLocalAddr() %></p>
	<p><label>server port:</label><%= request.getLocalPort()%></p>
	<p><label>client name:</label><%= request.getRemoteHost() %></p>	
	<%
		out.flush();	
		Thread.sleep(500+ new Random().nextInt(500));	
	%>
	<p><label>client ipAddress:</label><%= request.getRemoteAddr() %></p>
	<p><label>client port:</label><%= request.getRemotePort() %></p>
	<p><label>client Locale:</label><%= request.getLocale() %></p>
	<% //out.flush(); %>
	<p><label>requestURI:</label><%= request.getRequestURI() %></p>	
	<p><label>query string<a href='?id=A123456789&name=John'>請點選此連結</a>: </label><%= request.getQueryString() %></p>
	
	<form method='POST' >
		<input type='email' name='email' placeholder="請輸入email" required 
			value='<%= request.getParameter("email")==null?"":request.getParameter("email") %>'>
		<input type='submit' value='submit'>
	</form>
	
	<p><label>getParameter("id"):</label><%=request.getParameter("id") %></p>
	
	<hr>
	<h3>session(邏輯上的連線) <sup>**</sup></h3>
	<p>session id: <%= session.getId() %></p>
	<p>session Creation Time: <%= new Date(session.getCreationTime()) %></p>
	<p>session Last AccessedTime: <%= new Date(session.getLastAccessedTime())%></p>
	<p>session Max Inactive Interval: <%= session.getMaxInactiveInterval() %>秒</p>
	
	<hr>
	<h3>response, out</h3>
	<p><label>response buffer size:</label><%= response.getBufferSize()%></p>
	<p><label>response buffer size:</label><%= out.getBufferSize()%></p>
	<hr>
	
	<h3>application <sup>*</sup></h3>
	<p><label>contextPath: </label><%= application.getContextPath() %></p>
	<p><label>real Path: </label><%= application.getRealPath("/") %></p>
	<%
		Integer visitors = (Integer)application.getAttribute("vgb.app.visitors.counter");	
		application.setAttribute("vgb.app.visitors.counter", visitors!=null?++visitors:10000);
	%>
	<p><label>拜訪人次: </label><%= visitors %></p>
	<hr>
	<h3>config(直接改用this)</h3>
	<p><label>servlet name: </label><%= config.getServletName() %></p>
	<p><label>servlet name: </label><%= this.getServletName() %></p>
	<p><label>initial Parameter: </label><%= config.getInitParameter("greeting") %></p>
	<p><label>initial Parameter: </label><%= this.getInitParameter("greeting") %></p>
	
	<hr>
	<h3>page(直接改用this)</h3>
	<p><label>this.i:</label> <%= this.i %></p>
	<p><label>this==page:</label> <%= this==page %></p>
	<p><label>page.toString():</label> <%= page.toString() %></p>
	
	<hr>
	<h3>pageContext(直接改用其他的隱含變數)</h3>
	<p><label>context path:</label> 
		<%= ((HttpServletRequest)pageContext.getRequest()).getContextPath() %></p>
	<p><label>initial Parameter:</label> 
		<%= pageContext.getServletConfig().getInitParameter("greeting") %></p>
	
</body>
</html>