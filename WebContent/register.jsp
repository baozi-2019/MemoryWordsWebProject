<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<link rel="stylesheet" type="text/css" href="css/indexcss.css">
<body>
	<header><font color="#fffff"><h1>请认真填写以下信息</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<font color="red" size="3">
						<%
							Cookie[] cookies = request.getCookies();
							if (cookies != null){
								for (Cookie cookie : cookies) {
									if ("registerflag".equals(cookie.getName())) {
										out.print("用户名重复，请重新输入");
									}
								}
							}
						%>
					</font>
					<form action="RegisterServlet" method="post">
						<table>
							<tr>
								<td>用户名：</td>
								<td><input type="text" name="uname"></td>
							</tr>
							<tr>
								<td>密&nbsp;&nbsp;码：</td>
								<td><input type="password" name="upwd"></td>
							</tr>
							<tr>
								<td><input type="submit" value="提交"></td>
								<td><input type="reset" value="取消"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>	
</body>
	<div id="footer">
			&copy;by 包子
	</div>
</html>