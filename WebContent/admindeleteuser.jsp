<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员删除用户</title>
</head>
<link rel="stylesheet" type="text/css" href="css/addminadduser.css">
<body>
	<script type="text/javascript">
	function deletee() {
		document.deleteuser.action="AdminDeleteUser";
		document.deleteuser.submit();
	}
	function returnmauser() {
		document.deleteuser.action="manageuser.jsp";
		document.deleteuser.submit();
	}
	</script>
	<header><font color="#fffff"><h1>删除用户ing</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<form action="" method="post" name="deleteuser">
						<%
							Cookie[] cookies = request.getCookies();
							for (Cookie cookie : cookies) {
								if (cookie.equals("deleteuser")) {
									out.print("该用户不存在");
								}
							}
						%>
						<table>
							<tr>
								<td>用户名：</td>
								<td><input type="text" name="uname"></td>
							</tr>
							<tr>
								<td>是否为管理员：</td>
								<td><input name="chooseA" type="radio" value="yes" />是
									<input name="chooseA" type="radio" value="no">否 </td>
							</tr>
							<tr>
								<td><input type="button" value="删除" onclick="deletee()"></td>
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