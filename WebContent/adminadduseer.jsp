<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员增加用户</title>
</head>
<link rel="stylesheet" type="text/css" href="css/addminadduser.css">
<body>
	<script type="text/javascript">
	function sub() {
		document.adduser.action="AdminAddUser";
		document.adduser.submit();
	}
	function returnmauser() {
		document.adduser.action="manageuser.jsp";
		document.adduser.submit();
	}
	</script>
	<header><font color="#fffff"><h1>管理员添加用户</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<font color="red" size="3">
						<%
							Cookie[] cookies = request.getCookies();
							for (Cookie cookie : cookies) {
								if ("adminaduserflag".equals(cookie.getName())) {
									out.print("用户名重复，请重新输入");
								}
							}
						%>
					</font>
					<form action="" method="post" name="adduser">
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
								<td>是否为管理员：</td>
								<td><input name="chooseA" type="radio" value="yes" />是
									<input name="chooseA" type="radio" value="no">否 </td>
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