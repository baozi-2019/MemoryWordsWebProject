<%@page import="modle.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注销</title>
</head>
<link rel="stylesheet" type="text/css" href="css/indexcss.css">
<body>
 	<header><font color="#fffff"><h1>欢迎来背单词</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<%
						session.invalidate();
					%>
					已退出登录
					<a href="userLogin.jsp">点此返回登录页</a>
				</div>
			</div>
		</div>
	</div>	
</body>
<div id="footer">
			&copy;by 包子
		</div>
</html>