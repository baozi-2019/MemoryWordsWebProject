<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录失败</title>
</head>
<link rel="stylesheet" type="text/css" href="css/indexcss.css">
<body>
	<jsp:useBean id="showErro" class="javabean.ShowErro" scope="request"></jsp:useBean>
	<header><font color="#fffff"><h1>欢迎来背单词</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<%
						Cookie[] cookies = request.getCookies();
						int cookieSize = cookies.length;
						int i = 0;
						while (i < cookieSize && !"erroCode".equals(cookies[i].getName())) {
							i++;
						}
						int erroCode = Integer.parseInt(cookies[i].getValue());
					%>
					登录失败，
					<jsp:setProperty property="erroCode" name="showErro" value="<%= erroCode %>"/>
					<jsp:getProperty property="erroMessage" name="showErro"/><br/><br/>
					<a href="index.html">点此重新登录</a>
				</div>
			</div>
		</div>
	</div>	
</body>
<div id="footer">
			&copy;by 包子
		</div>
</html>