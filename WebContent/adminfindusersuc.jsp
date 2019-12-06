<%@page import="modle.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员查找用户成功</title>
</head>
<link rel="stylesheet" type="text/css" href="css/indexcss.css">
<body>
	<header><font color="#fffff"><h1>该用户信息如下</h1></font></header>
	<% Users user = (Users)session.getAttribute("userr"); %>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<table>
						<tr>
							<td>用户名：</td>
							<td><%= user.getName() %></td>
						</tr>
						<tr>
							<td>密&nbsp;&nbsp;码：</td>
							<td><%= user.getPassword() %></td>
						</tr>
						<tr>
							<td>是否为管理员：</td>
							<td><%= user.isAdmin() %></td>
						</tr>
					</table>
					<a href="manageuser.jsp">点此返回</a>
				</div>
			</div>
		</div>
	</div>	
</body>
<div id="footer">
			&copy;by 包子
		</div>
</html>