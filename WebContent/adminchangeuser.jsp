<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员改动用户</title>
</head>
<link rel="stylesheet" type="text/css" href="css/adminchangeuser.css">
<body>
	<script type="text/javascript">
	function sub() {
		document.adduser.action="AdminChangeUser";
		document.adduser.submit();
	}
	function returnmauser() {
		document.adduser.action="manageuser.jsp";
		document.adduser.submit();
	}
	</script>
	<header><font color="#fffff"><h1>请管理员更改用户信息</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<font color="red" size="3">
						<%
							Cookie[] cookies = request.getCookies();
							for (Cookie cookie : cookies) {
								if ("adminchangeuserflag".equals(cookie.getName())) {
									out.print("用户不存在，请先建立用户");
									break;
								}
							}
						%>
					</font>
					<form action="" method="post" name="adduser">
						<table>
							<tr>
								<td>要更改的用户名：</td>
								<td><input type="text" name="uname"></td>
							</tr>
							<tr>
								<td>新的密码：</td>
								<td><input type="password" name="upwd"></td>
							</tr>
							<tr>
								<td><input type="button" value="提交" onclick="sub()"></td>
								<td><input type="button" value="取消" onclick="returnmauser()"></td>
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