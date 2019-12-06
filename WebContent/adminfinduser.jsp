<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员查询用户</title>
</head>
<link rel="stylesheet" type="text/css" href="css/indexcss.css">
<body>
	<script type="text/javascript">
	function sub() {
		document.finduser.action="AdminFindUser";
		document.finduser.submit();
	}
	function returnmauser() {
		document.finduser.action="manageuser.jsp";
		document.finduser.submit();
	}
	</script>
	<header><font color="#fffff"><h1>管理员查找用户</h1></font></header>
	<div id="container">
		<div id="center">
			<div id="table">
				<div id="tables">
					<font color="red" size="3">
						<%
							Cookie[] cookies = request.getCookies();
							for (Cookie cookie : cookies) {
								if ("finduserflag".equals(cookie.getName())) {
									out.print("用户不存在，请先建立用户");
									break;
								}
							}
						%>
					</font>
					<form action="" method="post" name="finduser">
						<table>
							<tr>
								<td>用户名：</td>
								<td><input type="text" name="uname"></td>
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